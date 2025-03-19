ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "2.12.12"

lazy val root = (project in file("."))
  .settings(
    name := "uuid",
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.4.3" % Provided,
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)
