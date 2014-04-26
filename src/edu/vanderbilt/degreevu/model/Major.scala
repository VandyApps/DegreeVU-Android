package edu.vanderbilt.degreevu.model

import com.google.gson.JsonObject

/**
 * Represents a major
 *
 * Created by athran on 4/26/14.
 */
case class Major(id:   String,
                 name: String,
                 code: String)

object Major {

  val KEY_ID = "_id"
  val KEY_NAME = "majorCode"
  val KEY_CODE = "majorName"

  def readFromJson(json: JsonObject): Major = {
    Major(id   = json.get(KEY_ID).getAsString,
          name = json.get(KEY_NAME).getAsString,
          code = json.get(KEY_CODE).getAsString)
  }
}