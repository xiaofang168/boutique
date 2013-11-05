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

class AppModule{
  
}

@SubModule( Array(classOf[HibernateCoreModule]) )
object AppModule {
  
	def bind(binder: ServiceBinder ){
		binder.bind(classOf[CrudDAO], classOf[CrudDAOImpl]);
    }
  
	def contributeClasspathAssetAliasManager(configuration:MappedConfiguration[String,String]){
        configuration.add("assets", "assets");
    }
	
	//contribute factory defaults
    def contributeApplicationDefaults(configuration: MappedConfiguration[String, String]) {
        configuration.add(SymbolConstants.DEFAULT_STYLESHEET, "classpath:assets/css/style.css");
        configuration.add(HibernateSymbols.EARLY_START_UP, "true");
    }

	def contributeHibernateEntityPackageManager(configuration: Configuration[String] ) {
		configuration.add("com.boutique.entities");
	}

	@Match(Array[String]("*Service"))
	def adviseTransactions(advisor:HibernateTransactionAdvisor,receiver:MethodAdviceReceiver ) {
		advisor.addTransactionCommitAdvice(receiver);
	}
}