package edu.vanderbilt.degreevu.model

/**
 * Created by athran on 5/6/14.
 */
case class Semester(semType: SemesterType, year: Int)
{
  override def toString: String = {
    semType.name + " " + year
  }

  /**
   * An easy way to sort Semesters
   */
  def chronoCode = (year * 10) + semType.order

}

object Semester {

  /**
   * Order in ascending chronological order
   *
   * Fall 2012 -- Spring 2013 -- Spring 2014
   */
  def order(left: Semester, right: Semester): Int = {

    def booleanOrderToNum(order: Boolean) = if (order) 1 else -1

    def isSameYear = left.year == right.year

    if ((left eq right) || (left == right)) {
      0
    } else if (!isSameYear) {
      booleanOrderToNum(left.year < right.year)
    } else {
      booleanOrderToNum(left.semType.order < right.semType.order)
    }
  }

}
