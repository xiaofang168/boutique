/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Description:提供系统需要的操作工具
 * @Title: Utils.scala
 * @Prject: boutique
 * @Package: com.boutique.commons
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-18
 * @version: V1.0
 */
package com.boutique.commons

import java.util.List

/**
 * @ClassName: Utils
 * @Description: 系统工具类
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午5:55:37
 * @version: V1.0
 */
object Utils {

  def javaListConvertorScalaList(list: List[_]): scala.collection.immutable.List[_] = {
    return scala.collection.JavaConversions.asScalaBuffer(list).toList
  }

  def ScalaListConvertorjavaList(list: scala.collection.immutable.List[_]): List[_] = {
    return scala.collection.JavaConversions.asJavaList(list)
  }
}