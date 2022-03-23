ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "scala-practice"
  )

Compile / resourceDirectory := baseDirectory.value / "resources"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.7"
val QuillVersion = "1.2.2-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,

  "org.typelevel" %% "cats-core" % "2.1.0",

  //  "io.getquill" %% "quill-async-postgres" % QuillVersion,
  //  "io.getquill" %% "quill-jdbc" % QuillVersion,

  //  "io.getquill"          %% "quill-jdbc-zio" % "3.12.0",
  //  "io.github.kitlangton" %% "zio-magic"      % "0.3.11",

  "io.getquill" %% "quill-jdbc" % "3.16.3",
  "org.postgresql" % "postgresql" % "42.3.3",

  "org.scalatest" %% "scalatest" % "3.2.7" % Test,
  "com.h2database" % "h2" % "2.1.210" % Test,
)