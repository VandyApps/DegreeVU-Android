package edu.vanderbilt.degreevu.service

import android.app.{Activity, Fragment}
import android.os.HandlerThread

/**
 * Provide global backend services
 */
class AppService extends android.app.Application {

  import AppService._

  private val eventHubHandle        = HandlerActor.sync(new EventHub)
  private var serviceHandlers       = Seq.empty[HandlerActor]

  override def onCreate() {
    super.onCreate()
    val thread = new HandlerThread("backgroundThread")
    thread.start()

    serviceHandlers =
      List(new CourseServer,
           new UserManager,
           new MajorServer,
           new ScheduleServer).
      map(callback => HandlerActor.async(thread.getLooper,
                                         callback))

    serviceHandlers.foreach(_ ! Initialize(this))
  }

  def eventHub: HandlerActor                = eventHubHandle

  def courseServer: HandlerActor            = serviceHandlers(0)

  def userManager: HandlerActor             = serviceHandlers(1)

  def majorServer: HandlerActor             = serviceHandlers(2)

  def scheduleServer: HandlerActor          = serviceHandlers(3)

}

object AppService {

  /**
   * Allow easy access to the Application object in Activity
   */
  trait ActivityInjection {
    self: Activity =>

    def app = self.getApplication.asInstanceOf[AppService]

  }

  /**
   * Allow easy access to the Application object in Fragment
   */
  trait FragmentInjection {
    self: Fragment =>

    def app = self.getActivity.getApplication.asInstanceOf[AppService]

  }

  case class Initialize(ctx: AppService)

}