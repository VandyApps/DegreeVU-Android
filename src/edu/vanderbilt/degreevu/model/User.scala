package edu.vanderbilt.degreevu.model

import org.joda.time.DateTime

/**
 * Represents a user
 *
 * Created by athran on 4/26/14.
 */
case class User(id:             String,
                firstName:      String,
                lastName:       String,
                graduationYear: Int,
                primaryMajor:   Major,
                lastLogin:      DateTime)
{

}
