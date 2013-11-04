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

import org.junit.Test
import com.boutique.entities.User
import com.boutique.services.user.UserService
import org.apache.tapestry5.ioc.annotations.Inject
import org.junit.Assert

/**
 * @ClassName: DbTest
 * @Description: 数据库测试
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:21:56
 * @version: V1.0
 */

class DbTest {

	@Inject
	var userService:UserService = _
  
	@Test
	def saveUser(){
	  var user = new User()
	  user.id = 1
	  user.username = "fangjie"
	}
	
	@Test
	def getUser(){
	  Assert.assertNotNull(userService)
	}
}