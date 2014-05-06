package edu.vanderbilt.degreevu.util

import com.google.gson.JsonElement

/**
 * Convert Gson types into Scala types.
 *
 * Created by athran on 5/4/14.
 */
object GsonConversions {

  import scala.collection.JavaConverters._

  implicit def jsonToInt(json: JsonElement): Int =
    json.getAsInt

  implicit def jsonToDouble(json: JsonElement): Double =
    json.getAsDouble

  implicit def jsonToString(json: JsonElement): String =
    json.getAsString

  implicit def jsonToBoolean(json: JsonElement): Boolean =
    json.getAsBoolean

  implicit def jsonToIterable(json: JsonElement): Iterator[JsonElement] =
    json.getAsJsonArray.iterator().asScala

}
