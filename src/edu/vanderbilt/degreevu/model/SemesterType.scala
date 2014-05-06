package edu.vanderbilt.degreevu.model

/**
 * An enum representing Semester types
 *
 * Created by athran on 4/26/14.
 */
case class SemesterType(name: String, order: Int)

object SemesterType {

  val SPRING     = SemesterType("Spring", 1)
  val FALL       = SemesterType("Fall", 5)
  val SUMMER_ONE = SemesterType("Summer I", 2)
  val SUMMER_TWO = SemesterType("Summer II", 3)
  val MAYMESTER  = SemesterType("Maymester", 4)

  /**
   * Return all SemesterTypes in chronological order.
   */
  def all: Seq[SemesterType] = List(
                                     SPRING,
                                     SUMMER_ONE,
                                     SUMMER_TWO,
                                     MAYMESTER,
                                     FALL)

}
