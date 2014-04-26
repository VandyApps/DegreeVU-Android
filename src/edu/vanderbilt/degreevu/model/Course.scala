package edu.vanderbilt.degreevu.model

import com.google.gson.stream.JsonWriter
import com.google.gson.JsonObject

/**
 * Represents a course
 *
 * Created by athran on 4/26/14.
 */
case class Course(id:          String,
                  code:        String,
                  name:        String,
                  description: String,
                  credits:     Int)
{
  import Course._

  def writeToJson(writer: JsonWriter) {
    writer.
        beginObject().
        name(KEY_ID)  .value(this.id).
        name(KEY_CODE).value(this.code).
        name(KEY_NAME).value(this.name).
        name(KEY_DESC).value(this.description).
        name(KEY_CRED).value(this.credits).
        endObject()
  }
}

object Course {

  val KEY_ID = "_id"
  val KEY_CODE = "courseCode"
  val KEY_NAME = "courseName"
  val KEY_DESC = "courseDescription"
  val KEY_CRED = "courseCredits"

  def readFromJson(json: JsonObject): Course = {
    Course(id          = json.get(KEY_ID)  .getAsString,
           code        = json.get(KEY_CODE).getAsString,
           name        = json.get(KEY_NAME).getAsString,
           description = json.get(KEY_DESC).getAsString,
           credits     = json.get(KEY_CRED).getAsInt)
  }

}