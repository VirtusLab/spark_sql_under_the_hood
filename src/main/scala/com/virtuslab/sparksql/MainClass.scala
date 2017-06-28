package com.virtuslab.sparksql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Dataset, SparkSession}


object MainClass {

  case class Person(name: String, age: Option[Long])
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SparkSQL internals").setMaster("local[*]")

    val session = SparkSession.builder.config(conf).getOrCreate()

    import session.implicits._

    val peopleDataset: Dataset[Person] = session.read.json("src/main/resources/people.json").as[Person]

    peopleDataset.cache()

    val eldersDataset: Dataset[Person] = peopleDataset.filter(_.age.exists(_ > 65))

    eldersDataset.explain(extended = true)

    eldersDataset.queryExecution.debug.codegen()

    eldersDataset.write.save(s"results/generated/people_filtered_${System.currentTimeMillis()}")

    Console.in.read()

    session.stop()
  }
}
