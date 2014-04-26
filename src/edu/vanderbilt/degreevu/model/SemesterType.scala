package edu.vanderbilt.degreevu.model

/**
 * An enum representing Semester types
 *
 * Created by athran on 4/26/14.
 */
sealed trait SemesterType {

  def name: String

}

object SemesterType {

  case object Spring extends SemesterType {
    def name: String = "Spring"
  }

  case object Fall extends SemesterType {
    def name: String = "Fall"
  }

  case object SummerOne extends SemesterType {
    def name: String = "Summer 1"
  }

  case object SummerTwo extends SemesterType {
    def name: String = "Summer 2"
  }

  case object Maymester extends SemesterType {
    def name: String = "May"
  }

  def all: Seq[SemesterType] = List(Spring,
                                    SummerOne,
                                    SummerTwo,
                                    Maymester,
                                    Fall)

}
