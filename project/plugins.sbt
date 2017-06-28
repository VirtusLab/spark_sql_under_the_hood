// repositories
resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.url("jetbrains-bintray", url("http://dl.bintray.com/jetbrains/sbt-plugins/"))(Resolver.ivyStylePatterns),
  "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"
)

// Scoverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.2.0")

// Scalafmt
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.6.0")

// Spark packages
addSbtPlugin("org.spark-packages" % "sbt-spark-package" % "0.2.5")

// Assembly
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.3")
