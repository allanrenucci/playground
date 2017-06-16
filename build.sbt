lazy val playground = (project in file("."))
  .settings(
    scalaVersion := "2.12.2",
    clean in Test := IO.delete((classDirectory in Test).value),
    libraryDependencies ++= Seq(
    	"org.scalameta" %% "scalameta" % "1.8.0",
    	"org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )
