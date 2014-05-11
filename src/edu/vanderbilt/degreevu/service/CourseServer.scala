package edu.vanderbilt.degreevu.service

import edu.vanderbilt.degreevu.model.Course

/**
 * Created by athran on 4/26/14.
 */
object CourseServer {

  case class FetchCourseForToken(token: String)

  case class FetchCourseForString(str: String)

  case class FetchCourseForStatement(str: String)

  case object FetchAllCourses

  case class SearchCourse(searchTerm: String)

  sealed abstract class CourseSearchResult

  case class SearchFailure(searchTerm: String) extends CourseSearchResult

  case class SearchSuccess(searchTerm: String) extends CourseSearchResult

  case class CourseFetchResult(courses: Seq[Course])

}

private[service] class CourseServer extends Server {

  def init(ctx: AppService): Unit = {

  }

  def handleRequest(req: AnyRef): Unit = {

  }

  def handleTell(tell: AnyRef): Unit = {

  }

}
