package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.service.HandlerActor.Server

/**
 * Fetches schedule data
 *
 * Created by athran on 4/26/14.
 */
object ScheduleServer {

  case object FetchSchedules

}

private[service] class ScheduleServer extends Server {

  def init(ctx: AppService): Unit = {

  }

  def handleRequest(req: AnyRef): Unit = {

  }

  def handleTell(tell: AnyRef): Unit = {

  }

}
