package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.model.Major
import edu.vanderbilt.degreevu.framework.Server

/**
 * Manages User state, logins, updates
 *
 * Created by athran on 4/26/14.
 */
object UserManager {

  case class LoginWithToken(token: String)

  case object Logout

  case object FetchUserData

  case class PostNewGraduationYear(year: Int)

  case class PostNewMajor(major: Major)

  case object PostHodAsNewMajor

  case class FlunkOutOfEngineeringSchoolInto(major: Major)

  case object IsUserBlairStudent

}

private[service] class UserManager extends Server {

  override def handleRequest(req: AnyRef): Unit = {

  }

}
