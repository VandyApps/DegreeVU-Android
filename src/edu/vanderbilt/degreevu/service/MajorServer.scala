package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.service.HandlerActor.Server

/**
 * Fetches Major data
 *
 * Created by athran on 4/26/14.
 */
object MajorServer {

  case class FetchMajorWithId(id: String)

  case class FetchMajorWithCode(code: String)

}

private[service] class MajorServer extends Server {

  def init(ctx: AppService): Unit = {

  }

  def handleRequest(req: AnyRef): Unit = {

  }

  def handleTell(tell: AnyRef): Unit = {

  }

}
