/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: DbTest.scala
 * @Prject: boutique
 * @Package: com.boutique
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:21:56
 * @version: V1.0
 */
package com.boutique

import org.apache.tapestry5.ioc.IOCUtilities
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import com.boutique.entities.User
import com.boutique.services.user.UserService

import javax.persistence.Entity
import javax.persistence.Table

/**
 * @ClassName: DbTest
 * @Description: 数据库测试
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:21:56
 * @version: V1.0
 */

class DbTest {
  
	var userService: UserService = _
  
	var container: Container = _
	
	@Before
	def start(){
		container = Container.getInstance()
	}
	
	@Test
	def saveUser(){
	  var user = new User()
	  user.id = 1
	  user.username = "fangjie"
	}
	
	@Test
	def getUser(){
	  Assert.assertNotNull(container)
	}
}