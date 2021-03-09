val scala211 = "2.11.10"
val scala212 = "2.12.7"

ThisBuild / scalaVersion := scala212
ThisBuild / organization := "com.example"

lazy val commonSettings: SettingsDefinition = Def.settings(
  libraryDependencies ++= Seq(
    "org.scalameta" %% "munit" % "0.7.20" % Test,
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
  )
)

lazy val hello_212 = (projectMatrix in file("."))
  .settings(commonSettings)
  .settings(
    libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.9",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  ).jvmPlatform(scalaVersions = Seq(scala212))


lazy val hello_211 = (projectMatrix in file("."))
  .settings(commonSettings)
  .settings(
      libraryDependencies += "com.typesafe.play" %% "play-json" % "2.3.9",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  ).jvmPlatform(scalaVersions = Seq(scala211))

test in assembly := {}
