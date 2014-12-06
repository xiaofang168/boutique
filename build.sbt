name := "boutique"

version := "1.0"

scalaVersion := "2.10.3"

resolvers ++= Seq(
     "typesafe" at "http://repo.typesafe.com/typesafe/releases",
     "defautl" at "http://repo1.maven.org/maven2",
     "ibiblio" at "http://mirrors.ibiblio.org/maven2", 
     "devlab722" at "http://nexus.devlab722.net/nexus/content/repositories/releases"
)

libraryDependencies ++= Seq(
    "org.apache.tapestry" % "tapestry-core" % "5.3.7",
    "org.got5" % "tapestry5-jquery" % "3.3.4",
    "org.apache.tapestry" % "tapestry-upload" % "5.3.7",
    "org.apache.tapestry" % "tapestry-hibernate" % "5.3.7",
    "org.apache.tapestry" % "tapestry-beanvalidator" % "5.3.7",
    "org.hibernate.javax.persistence" % "hibernate-jpa-2.0-api" % "1.0.1.Final",
    "org.hibernate" % "hibernate-validator" % "5.0.1.Final",
    "net.sourceforge.tapestrytestify" % "tapestry-testify" % "1.0.4",
    "org.chenillekit" % "chenillekit-tapestry" % "1.3.3",
    "com.h2database" % "h2" % "1.3.171",
    "log4j" % "log4j" % "1.2.12",
    "org.slf4j" % "slf4j-api" % "1.5.8",
    "commons-collections" % "commons-collections" % "3.2",
    "javax.validation" % "validation-api" % "1.1.0.Final",
    "org.directwebremoting" % "dwr" % "3.0.M1",
    "commons-logging" % "commons-logging" % "1.1.3",
    "junit" % "junit" % "4.4" % "test"
)

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

//添加额外源代码目录
//unmanagedSourceDirectories in Compile += baseDirectory.value / "src/main/conf/development"

//添加额外的资源目录
unmanagedResourceDirectories in Compile += baseDirectory.value / "src/main/conf/development"

javacOptions ++= Seq("-source", "1.6", "-encoding", "UTF-8", "-target", "1.6")

scalacOptions ++= Seq("-encoding", "UTF-8", "-target:jvm-1.6")

compileOrder := CompileOrder.JavaThenScala

EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE16)