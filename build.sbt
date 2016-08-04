name := "finagle-test"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq (
  "com.twitter" %% "finagle-http" % "6.24.0",
  "com.twitter" %% "finagle-thrift" % "6.24.0",
  "com.twitter" %% "scrooge-core" % "3.17.0",
  "org.apache.thrift" % "libthrift" % "0.9.1"
)

com.twitter.scrooge.ScroogeSBT.newSettings
