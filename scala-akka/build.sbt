ScriptedPlugin.globalSettings

resolvers += Classpaths.typesafeReleases

name := "message-service"

version := "1.0.0"

scalaVersion := "2.13.1"

lazy val akkaVersion = "2.6.4"
lazy val akkaHttpVersion = "10.1.11"
lazy val slick = "3.3.2"
lazy val scalaTest = "3.1.1"
lazy val json4s = "3.6.7"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)

libraryDependencies ++= Seq(
  // Akka dependencies
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "org.json4s" %% "json4s-native" % json4s,
  "org.json4s" %% "json4s-jackson" % json4s,
  "de.heikoseeberger" %% "akka-http-json4s" % "1.31.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",

  //"javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",

  // Database dependencies
  "com.typesafe.slick" %% "slick" % slick,
  "org.postgresql" % "postgresql" % "42.2.11",
  "com.typesafe.slick" %% "slick-hikaricp" % slick,

  // Test dependencies
  "org.scalatest" %% "scalatest" % scalaTest % "test"
)
