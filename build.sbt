inThisBuild(Seq(
  scalaVersion := "2.12.6"
  // scalaVersion := "2.13.0-M4"
))

lazy val root = project
  .in(file("."))
  .aggregate(playground)

lazy val playground = project
  .in(file("playground"))
  .settings(
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.jline" % "jline" % "3.7.0",
    	// "org.scalameta" %% "scalameta" % "1.8.0",
    	// "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )
