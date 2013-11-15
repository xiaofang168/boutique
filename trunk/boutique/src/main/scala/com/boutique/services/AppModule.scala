package com.boutique.services

import org.apache.tapestry5.SymbolConstants
import org.apache.tapestry5.hibernate.HibernateSymbols
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor
import org.apache.tapestry5.ioc.Configuration
import org.apache.tapestry5.ioc.MappedConfiguration
import org.apache.tapestry5.ioc.MethodAdviceReceiver
import org.apache.tapestry5.ioc.annotations.Match
import org.apache.tapestry5.ioc.annotations.SubModule
import org.apache.tapestry5.hibernate.HibernateCoreModule
import com.boutique.dao.CrudDAO
import com.boutique.dao.impl.CrudDAOImpl
import org.apache.tapestry5.ioc.ServiceBinder
import org.apache.tapestry5.hibernate.HibernateTransactionDecorator

@SubModule(Array(classOf[HibernateCoreModule], classOf[UserModule]))
object AppModule {

  def bind(binder: ServiceBinder) {
    binder.bind(classOf[CrudDAO], classOf[CrudDAOImpl]);
  }

  //contribute factory defaults
  def contributeApplicationDefaults(configuration: MappedConfiguration[String, String]) {
    configuration.add(HibernateSymbols.EARLY_START_UP, "true");
  }

  def contributeHibernateEntityPackageManager(configuration: Configuration[String]) {
    configuration.add("com.boutique.entities");
  }

  
  @Match(Array[String]("*Service"))
  def decorateTransactions[T](serviceInterface: Class[T], delegate: T, serviceId: String, decorator: HibernateTransactionDecorator): T = {
    return decorator.build(serviceInterface, delegate, serviceId)
  }
  
}