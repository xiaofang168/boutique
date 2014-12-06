/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Description: 测试系统工具类文件
 * @Title: UtilsTest.scala
 * @Prject: boutique
 * @Package: com.boutique.commons
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-18
 * @version: V1.0
 */
package com.boutique.commons

import java.util.ArrayList

import scala.collection.JavaConverters.asScalaBufferConverter
import scala.collection.JavaConverters.bufferAsJavaListConverter
import scala.collection.mutable.Buffer
import scala.collection.mutable.ListBuffer
import scala.collection.JavaConverters._

import org.junit.Assert
import org.junit.Test

/**
 * @ClassName: UtilsTest
 * @Description: 工具类测试
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午6:04:25
 * @version: V1.0
 */
class UtilsTest {

  @Test
  def testScalaListConvertorjavaList() {
	  var scalaList:ListBuffer[_] = ListBuffer("1","2")
	  var javaList:java.util.List[_]= scalaList.asJava
	  Assert.assertEquals(2, javaList.size())
  }

  @Test
  def testJavaListConvertorScalaList() {
	  var javaList:java.util.List[String] = new ArrayList[String]()
	  javaList.add("1")
	  javaList.add("2")
	  var scalaList:Buffer[_]= javaList.asScala
	  Assert.assertEquals(2, scalaList.length)
  }
}