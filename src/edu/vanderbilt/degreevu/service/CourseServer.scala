package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.service.HandlerActor.Server

/**
 * Created by athran on 4/26/14.
 */
object CourseServer {

  case class FetchCourseForToken(token: String)

  case class FetchCourseForString(str: String)

}

private[service] class CourseServer extends Server {

  def init(ctx: AppService): Unit = {

  }

  def handleRequest(req: AnyRef): Unit = {

  }

  def handleTell(tell: AnyRef): Unit = {

  }

}
