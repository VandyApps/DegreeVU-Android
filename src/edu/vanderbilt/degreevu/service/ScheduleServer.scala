package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.framework.Server

/**
 * Fetches schedule data
 *
 * Created by athran on 4/26/14.
 */
object ScheduleServer {

  case object FetchSchedules

}

private[service] class ScheduleServer extends Server {

  override def handleRequest(req: AnyRef): Unit = {

  }

}
