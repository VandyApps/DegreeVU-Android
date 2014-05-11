package edu.vanderbilt.degreevu.service

import android.app.{Activity, Fragment}
import android.os.{Handler, HandlerThread}

/**
 * Provide global backend services
 */
class AppService extends android.app.Application with ActorConversion {

  import AppService._

  private val eventHubHandle        = new Handler(new EventHub)
  private var serviceHandlers       = Seq.empty[Handler]

  override def onCreate() {
    super.onCreate()
    val thread = new HandlerThread("backgroundThread")
    thread.start()

    serviceHandlers =
      List(new CourseServer,
           new UserManager,
           new MajorServer,
           new ScheduleServer).
      map(callback => new Handler(thread.getLooper,
                                   callback))

    serviceHandlers.foreach(_ ! Initialize(this))
  }

  def eventHub: Handler                = eventHubHandle

  def courseServer: Handler            = serviceHandlers(0)

  def userManager: Handler             = serviceHandlers(1)

  def majorServer: Handler             = serviceHandlers(2)

  def scheduleServer: Handler          = serviceHandlers(3)

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