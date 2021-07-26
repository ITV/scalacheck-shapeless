
import sbt.Global
import sbtcrossproject.crossProject

inThisBuild(List(
  organization := "com.github.alexarchambault",
  homepage := Some(url("https://github.com/alexarchambault/scalacheck-shapeless")),
  licenses := Seq("Apache 2.0" -> url("http://opensource.org/licenses/Apache-2.0")),
  developers := List(Developer(
    "alexarchambault",
    "Alexandre Archambault",
    "",
    url("https://github.com/alexarchambault")
  )),
    Global / onChangedBuildSource := ReloadOnSourceChanges,
  scalaVersion := Scala.scala3
))


lazy val core = crossProject(JVMPlatform)
  .settings(
    scalaVersion := Scala.scala3,
    //crossScalaVersions := Scala.all,
    scalacOptions ++= Seq(
      "-deprecation",
      "-source:3.0",
      "-no-indent"
    ),
    name := "scalacheck-shapeless_2.0",
    moduleName := name.value, // keep the '.' in name ^
    libraryDependencies ++= Seq(
      Deps.scalacheck.value,
      Deps.shapeless.value,
      Deps.utest.value % Test
    ),
    testFrameworks += new TestFramework("utest.runner.Framework"),
    mimaPreviousArtifacts := Set.empty,
    semanticdbVersion := "4.4.24"
  )

disablePlugins(MimaPlugin)
skip.in(publish) := true
crossScalaVersions := Nil
