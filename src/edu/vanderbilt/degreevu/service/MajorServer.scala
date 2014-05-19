package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.framework.Server

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

  override def handleRequest(req: AnyRef): Unit = {

  }

}
