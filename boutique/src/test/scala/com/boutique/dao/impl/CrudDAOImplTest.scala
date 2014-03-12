/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: CrudDAOImplTest.java
 * @Prject: boutique
 * @Package: com.boutique.dao.impl
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-8 下午2:56:21
 * @version: V1.0
 */
package com.boutique.dao.impl;

import org.junit.Test
import com.boutique.Container
import com.boutique.dao.CrudDAO
import com.boutique.entities.User
import javax.persistence.Entity
import javax.persistence.Table
import junit.framework.Assert

/**
 * @ClassName: CrudDAOImplTest
 * @Description: 增删改查测试类
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-8 下午2:56:21
 * @version: V1.0
 */
class CrudDAOImplTest{

	private var crudDao: CrudDAO  = Container.getInstance().getService(classOf[CrudDAO])
	
	@Test
	def testSave() = {
		var user = new User
		user.username = "fangjie"
		user.password = "1234"
		crudDao.save(user)
		Assert.assertNotNull(user.id)
	}

	
	@Test
	def testGet() = {
		var user = crudDao.get(classOf[User], 1l.asInstanceOf[java.io.Serializable])
		Assert.assertEquals(1, user.id)
	}
	
	@Test
	def testFind() = {
	  testSave
	  var list = crudDao.find("from User")
	  Assert.assertEquals(1, list.size)
	}
	
	@Test
	def getFindHqlParams() = {
	  testSave
	  var list = crudDao.find("from User u where u.username = ? and u.password = ?",Array("fangjie","1234"))
	  Assert.assertEquals(1, list.size)
	}
	
	@Test
	def signUp() = {
	   var userVerif = crudDao.find("from User u where u.username=? and u.email=?", Array("xiaofang168", "hbxffj@163.com"))
	   Assert.assertTrue(userVerif.isEmpty)
	}

}
