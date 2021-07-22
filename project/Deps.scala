import sbt._
import sbt.Keys.scalaVersion

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Deps {

  import Def.setting

  def scalacheck = setting("org.scalacheck" %%% "scalacheck" % "1.15.4")
  def shapeless = setting("org.typelevel" %%% "shapeless3-deriving" % "3.0.2")
  def utest = setting("com.lihaoyi" %%% "utest" % "0.7.10")
}
