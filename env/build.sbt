name := "vault-plugin"

version := "1.0"

resolvers += "Mesosphere Public Repo" at "http://downloads.mesosphere.io/maven"

libraryDependencies ++= Seq(
  "mesosphere.marathon" %% "plugin-interface" % "1.3.5" % "provided",
  "log4j" % "log4j" % "1.2.17" % "provided",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalaj" %% "scalaj-http" % "2.3.0"
)

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
}
