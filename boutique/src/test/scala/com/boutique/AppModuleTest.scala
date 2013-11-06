/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: AppModuleTest.scala
 * @Prject: boutique
 * @Package: com.boutique
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-6 上午10:15:18
 * @version: V1.0
 */
package com.boutique

import org.apache.tapestry5.ioc.ServiceBinder
import org.apache.tapestry5.ioc.MethodAdviceReceiver
import org.apache.tapestry5.ioc.MappedConfiguration
import org.apache.tapestry5.hibernate.HibernateTransactionAdvisor
import com.boutique.dao.CrudDAO
import com.boutique.dao.impl.CrudDAOImpl
import org.apache.tapestry5.hibernate.HibernateSymbols
import org.apache.tapestry5.SymbolConstants
import org.apache.tapestry5.ioc.Configuration
import org.apache.tapestry5.ioc.annotations.Match

/**
 * @ClassName: AppModuleTest
 * @Description: 测试用的appModule
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-6 上午10:15:18
 * @version: V1.0
 */
class AppModuleTest{}
object AppModuleTest {
  
	def bind(binder: ServiceBinder ){
		binder.bind(classOf[CrudDAO], classOf[CrudDAOImpl]);
    }
	
	//contribute factory defaults
    def contributeApplicationDefaults(configuration: MappedConfiguration[String, String]) {
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