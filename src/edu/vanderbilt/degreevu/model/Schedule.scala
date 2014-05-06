package edu.vanderbilt.degreevu.model

import scala.collection.mutable
import Schedule._

/**
 * Schedule. What more to say?
 *
 * Created by athran on 4/26/14.
 */
trait Schedule extends ThreadSafety {

  def title: String

  def title_=(title: String)

  def graduationYear: Int

  def hours: Int

  def isNew: Boolean

  def view(semester: Semester): SemesterView

  def semesters: Set[Semester]

  def coursesIn(semester: Semester): Set[Course]

  def empty(): Unit

}

object Schedule {

  def withTitleAndGradYear(title: String, year: Int): Schedule = {
    new BasicSchedule(title, year)
  }

  trait SemesterView {

    private[Schedule$] val courses: mutable.Set[Course]
    private[Schedule$] val parent: BasicSchedule

    def addCourse(course: Course): Unit = {
      courses.add(course)
      parent._hours += course.credits
    }

    def deleteCourse(course: Course): Unit = {
      courses.remove(course)
      parent._hours -= course.credits
    }

    def deleteAllCourses(): Unit = {
      parent._hours -= courses.map(_.credits).sum
      courses.empty
    }

    def allCourses: Set[Course] = courses.toSet

    def hours = courses.map(_.credits).sum

  }

  trait ThreadSafety {
    self: Schedule =>

    def getHardVersion: HardSchedule = {
      HardSchedule("",
                    self.title,
                    self.graduationYear,
                    self.semesters.
                        map(sem => (sem, self.coursesIn(sem))).
                        map(pair => SemesterRecord(pair._1, pair._2)))
    }

  }

  /**
   * An immutable Schedule for safe trans-thread transfer
   */
  case class HardSchedule(id: String,
                          title: String,
                          graduationYear: Int,
                          courses: Set[SemesterRecord])

  case class SemesterRecord(semester: Semester,
                            courses: Set[Course])

  private[Schedule$] class BasicSchedule(var title: String,
                                         val graduationYear: Int)
      extends Schedule
  {
    var _hours = 0

    def hours: Int = _hours

    def isNew: Boolean = false

    def view(semester: Semester): Option[SemesterView] = {
      // Magic
      for (maybeRecord <- records.find(_._1 eq semester)) yield {
        new SemesterView {
          private[Schedule$] val courses: mutable.Set[Course] = maybeRecord._2
          private[Schedule$] val parent : BasicSchedule       = BasicSchedule.this
        }
      }
    }

    val records = {
      for (year    <- (graduationYear - 3) to graduationYear;
           semType <- SemesterType.all) yield {
        if (semType eq SemesterType.FALL) { (Semester(semType, year - 1), mutable.Set.empty[Course]) }
        else { (Semester(semType, year), mutable.Set.empty[Course]) }
      }
    }.toSet

    def semesters = records.map(_._1)

    def coursesIn(semester: Semester): Option[Set[Course]] = {
      for (record <- records.find(_._1 == semester)) yield record._2.toSet
    }

    def empty() {
      records.foreach(_._2.empty)
      _hours = 0
    }

  }

}