package edu.vanderbilt.degreevu.service

import android.os.{Handler, HandlerThread}
import edu.vanderbilt.degreevu.framework.{Initialize, EventfulApp}

/**
 * Provide global backend services
 */
class AppService extends android.app.Application with EventfulApp {

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

  def courseServer: Handler            = serviceHandlers(0)

  def userManager: Handler             = serviceHandlers(1)

  def majorServer: Handler             = serviceHandlers(2)

  def scheduleServer: Handler          = serviceHandlers(3)

}
