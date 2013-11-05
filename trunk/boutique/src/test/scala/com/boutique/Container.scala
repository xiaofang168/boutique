/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: Container.scala
 * @Prject: boutique
 * @Package: com.boutique
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-5 上午9:43:23
 * @version: V1.0
 */
package com.boutique

import scala.actors.threadpool.locks.ReentrantLock
import org.apache.tapestry5.ioc.Registry
import org.apache.tapestry5.ioc.RegistryBuilder
import com.boutique.services.AppModule
import scala.collection.Seq

/**
 * @ClassName: Container
 * @Description: tapestry 管理容器
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-5 上午9:43:24
 * @version: V1.0
 */
class Container private () {
	var registry: Registry = _
	
	def this(moduleClasses: Class[_]*) {
	  this
	  this.initRegistry(moduleClasses: _*)
	}
	
	private def initRegistry(moduleClasses: Class[_]*) {
	    var builder = new RegistryBuilder()
	    var classes = Seq(moduleClasses):+Seq(AppModule.getClass())
	    System.setProperty("tapestry.modules", classes.map(_.getClass().getName())mkString(","));
	    //build registry instance
	    registry = builder.build()
	    registry.performRegistryStartup()
	}

	/**
	 * get service instance
	 * @param class service interface class
	 * @since 0.1
	 */
	def getService[T](serviceInterface: Class[T]): T = {
			return registry.getService(serviceInterface)
	}

	/**
	* 得到一个服务
	* @param serviceInterface 服务接口
	* @param serviceId 服务的ID
	* @return 服务的实例
	* @since 0.1
	*/
	def getService[T](serviceInterface: Class[T], serviceId: String): T = {
			return registry.getService(serviceId, serviceInterface);
	}

}

object Container {
	private var container: Container = _
	private var registry: Registry = _
	private def lock: ReentrantLock = new ReentrantLock()
	
	def getInstance: Container = {
			if (container == null) {
				try {
					lock.lock()
					if (container == null) {
						//container = new Container()
					}
				} finally {
					lock.unlock()
				}
	}
    return container
	}

	def getInstance(moduleClasses: Class[_]*): Container = {
			if (container == null) {
				try {
					lock.lock();
					if (container == null) {
						container = new Container(moduleClasses: _*)
					}
				} finally {
					lock.unlock();
				}
			}
			return container;
	}

	def shutdown() {
		if (container != null && container.registry != null) {
			container.registry.shutdown()
		}
	}

}
