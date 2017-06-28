val sparkVersion = "2.1.1"

val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

val root = (project in file("."))
  .settings(
    name := "spark_sql_under_the_hood",
    organization := "com.virtuslab",
    version := "1.0",
    scalaVersion := "2.11.11",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    mainClass in (Compile, run) := Some("com.virtuslab.sparksql.MainClass"),
    assemblyJarName in assembly := s"${name.value}-spark$sparkVersion.jar", //Artifact name
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", _) => MergeStrategy.discard
      case _ => MergeStrategy.first
    },
    libraryDependencies ++= sparkDependencies
  )
