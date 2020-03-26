ScriptedPlugin.globalSettings

resolvers += Classpaths.typesafeReleases

name := "account-service"

version := "0.1"

scalaVersion := "2.12.4"

val scalatraVersion = "2.6.+"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)

libraryDependencies ++= Seq(

  // Scalatra dependencies
  "org.scalatra" %% "scalatra" % scalatraVersion,
  "org.scalatra" %% "scalatra-swagger" % scalatraVersion,
  "org.scalatra" %% "scalatra-json" % scalatraVersion,
  "org.scalatra" %% "scalatra-scalate" % scalatraVersion,
  "org.json4s" %% "json4s-native" % "3.6.3",

  // Jetty dependencies
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",

  // Database dependencies
  "com.typesafe.slick" %% "slick" % "3.3.1",
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.1",
  "com.zaxxer" % "HikariCP" % "3.3.1",

  // Test dependencies
  "org.scalatra" %% "scalatra-specs2" % scalatraVersion % "test",
  "org.scalatra" %% "scalatra-scalatest" % scalatraVersion % "test"
)

enablePlugins(ScalatraPlugin)
