/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Title: LocaleBar.scala
 * @Prject: boutique
 * @Package: com.boutique.components
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-6
 * @version: V1.0
 */
package com.boutique.components

import java.util.Locale
import scala.collection.immutable.List
import org.apache.tapestry5.SymbolConstants
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.annotations.Service
import org.apache.tapestry5.annotations.SessionAttribute
import org.apache.tapestry5.annotations.SetupRender
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.ioc.services.SymbolProvider
import org.apache.tapestry5.services.PersistentLocale
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.boutique.model.LocaleSelectModel
import scala.collection.mutable.ListBuffer

class LocaleBar {

  private var logger: Logger = LoggerFactory.getLogger(classOf[LocaleBar])

  @Property
  @SessionAttribute("locale")
  private var locale: String = _

  @Inject
  @Service("ApplicationDefaults")
  private var symbolProvider: SymbolProvider = _

  @Inject
  private var persistentLocale: PersistentLocale = _

  @Property
  private var LocalesModel: LocaleSelectModel = _

  @SetupRender
  def initLocale() {
    if (persistentLocale.get() == null) {
      this.locale = Locale.getDefault().toString().toLowerCase()
      logger.debug(locale)
    } else {
      this.locale = persistentLocale.get().getLanguage()
      if (this.locale.contains("zh")) {
        this.locale = "zh_cn"
      }
      logger.debug(locale)
    }
  }

  def getLocales(): Array[String] = {
    var symbol = symbolProvider.valueForSymbol(SymbolConstants.SUPPORTED_LOCALES)
    symbol.split(",")
  }

  def toLocale(shortName: String): Locale = {
    var result = shortName.split("_")
    if (result.length == 1) {
      new Locale(result(0))
    } else {
      return new Locale(result(0), result(1))
    }
  }

  def onPrepare() = {
    var localeList = ListBuffer[Locale]()
    getLocales().foreach(locale => {
      localeList += new Locale(locale)
    })
    LocalesModel = new LocaleSelectModel(localeList)
  }

  def onSubmitFromForm() {
    persistentLocale.set(toLocale(locale))
    logger.debug(persistentLocale.get().getLanguage())
  }

}