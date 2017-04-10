name := "spark-examples"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
    "org.apache.spark" % "spark-core_2.11" % "2.0.0",
    "org.apache.spark" % "spark-sql_2.11" % "2.0.0",
    "org.scala-lang" % "scala-compiler" %  "2.11.8",
    "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
)

/*
"org.apache.hadoop" % "hadoop-common" % "2.7.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
    "org.apache.spark" % "spark-sql_2.11" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
    "org.apache.spark" % "spark-hive_2.11" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
    "org.apache.spark" % "spark-yarn_2.11" % "1.6.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")

 */

/*
"org.apache.hadoop" % "hadoop-common" % "2.7.0" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
"org.apache.spark" % "spark-hive" % "2.0.0" % "provided" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy"),
"org.apache.spark" % "spark-yarn" % "2.0.0" % "provided" exclude ("org.apache.hadoop","hadoop-yarn-server-web-proxy")
*/

// http://queirozf.com/entries/creating-scala-fat-jars-for-spark-on-sbt-with-sbt-assembly-plugin
assemblyMergeStrategy in assembly := {
  case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
