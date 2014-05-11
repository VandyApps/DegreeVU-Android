package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.model.Major

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

  def init(ctx: AppService): Unit = {

  }

  def handleRequest(req: AnyRef): Unit = {

  }

  def handleTell(tell: AnyRef): Unit = {

  }

}
