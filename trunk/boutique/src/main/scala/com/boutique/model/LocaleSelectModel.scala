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

import org.apache.tapestry5.util.AbstractSelectModel
import org.apache.tapestry5.OptionModel
import org.apache.tapestry5.internal.OptionModelImpl
import org.apache.tapestry5.OptionGroupModel
import java.util.Locale
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @ClassName: LocaleSelectModel
 * @Description:
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @time: 下午4:10:16
 * @version: V1.0
 */
class LocaleSelectModel(Locales: List[Locale]) extends  AbstractSelectModel{
	
	private var logger:Logger = LoggerFactory.getLogger(classOf[LocaleSelectModel])
  
    override def getOptionGroups(): java.util.List[OptionGroupModel] = {
        return null
    }
    
    override def getOptions():java.util.List[OptionModel] = {
        var options = List[OptionModel]()
        Locales.foreach(locale=>{
          options ::=  new OptionModelImpl(locale.getDisplayName().replaceAll("zh_cn", "中文"),locale.getLanguage())
        })
        scala.collection.JavaConversions.asJavaList(options)
    }
}