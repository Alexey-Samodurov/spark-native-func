package org.apache.spark.sql

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.apache.spark.sql.UuidFunctions.uuid

class UuidSpec extends AnyFlatSpec with should.Matchers {
  val spark: SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("test")
    .getOrCreate()

  "Custom UUID function in Dataframe API" should "work" in {
    val df: DataFrame = spark.range(0, 10, 1, 1).toDF("id")
      .withColumn("uuid", uuid())

    df.printSchema
    df.show(10, truncate = false)
  }

  "Custom UUID function in native SQL" should "work" in {
    val df = spark.range(0, 10).toDF("id")
    df.createOrReplaceTempView("numbers")
    val result = spark.sql("SELECT id, uuid() as uuid FROM numbers")
    result.printSchema()
    result.show(truncate = false)
  }
}
