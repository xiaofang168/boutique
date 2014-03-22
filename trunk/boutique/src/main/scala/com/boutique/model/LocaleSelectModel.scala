/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Title: LocaleSelectModel.scala
 * @Prject: boutique
 * @Package: com.boutique.model
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-6
 * @version: V1.0
 */
package com.boutique.model

import java.util.Locale

import scala.collection.JavaConverters.bufferAsJavaListConverter
import scala.collection.mutable.ListBuffer

import org.apache.tapestry5.OptionGroupModel
import org.apache.tapestry5.OptionModel
import org.apache.tapestry5.internal.OptionModelImpl
import org.apache.tapestry5.util.AbstractSelectModel
import scala.collection.JavaConverters._
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @ClassName: LocaleSelectModel
 * @Description:
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @time: 下午4:10:16
 * @version: V1.0
 */
class LocaleSelectModel(Locales: ListBuffer[Locale]) extends AbstractSelectModel {

  private var logger: Logger = LoggerFactory.getLogger(classOf[LocaleSelectModel])

  override def getOptionGroups(): java.util.List[OptionGroupModel] = {
    return null
  }

  override def getOptions(): java.util.List[OptionModel] = {
    var options = new scala.collection.mutable.ListBuffer[OptionModel]
    Locales.foreach(locale => {
      options += new OptionModelImpl(locale.getDisplayName().replaceAll("zh_cn", "中文"), locale.getLanguage())
    })
    return options.asJava
  }
}