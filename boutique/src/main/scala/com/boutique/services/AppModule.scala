package com.boutique.services

import org.apache.tapestry5.SymbolConstants
import org.apache.tapestry5.hibernate.HibernateSymbols
import org.apache.tapestry5.hibernate.HibernateTransactionDecorator
import org.apache.tapestry5.ioc.Configuration
import org.apache.tapestry5.ioc.MappedConfiguration
import org.apache.tapestry5.ioc.ServiceBinder
import org.apache.tapestry5.ioc.annotations.Match
import org.apache.tapestry5.ioc.annotations.SubModule
import com.boutique.dao.CrudDAO
import com.boutique.dao.impl.CrudDAOImpl
import org.apache.tapestry5.hibernate.HibernateCoreModule
import org.got5.tapestry5.jquery.JQuerySymbolConstants

@SubModule(Array(classOf[HibernateCoreModule], classOf[UserModule], classOf[WebModule]))
object AppModule {

  def bind(binder: ServiceBinder) {
    binder.bind(classOf[CrudDAO], classOf[CrudDAOImpl]);
  }

  //contribute factory defaults
  def contributeApplicationDefaults(configuration: MappedConfiguration[String, String]) {
    configuration.add(SymbolConstants.DEFAULT_STYLESHEET, "context:static/css/default.css")
    configuration.add(HibernateSymbols.EARLY_START_UP, "true")
    configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en")
    configuration.add(SymbolConstants.PRODUCTION_MODE, "false")
    configuration.add(SymbolConstants.HMAC_PASSPHRASE, "MD5")
    configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT")
    // We have Tapestry5jQuery installed. Tell it we don't want it to suppress Prototype and Scriptaculous.
    configuration.add(JQuerySymbolConstants.SUPPRESS_PROTOTYPE, "false");
    // We don't use $j in our javascript - instead we use function scoping (see
    // http://api.jquery.com/jQuery.noConflict/)
    // but we need this next line to keep Tapestry happy (since Tapestry 5.3.4).
    configuration.add(JQuerySymbolConstants.JQUERY_ALIAS, "$j");
  }

  def contributeHibernateEntityPackageManager(configuration: Configuration[String]) {
    configuration.add("com.boutique.entities");
  }

  @Match(Array[String]("*Service"))
  def decorateTransactions[T](serviceInterface: Class[T], delegate: T, serviceId: String, decorator: HibernateTransactionDecorator): T = {
    return decorator.build(serviceInterface, delegate, serviceId)
  }

}