package com.boutique.services.user

import org.apache.tapestry5.hibernate.annotations.CommitAfter
import org.junit.Assert
import org.junit.Test

import com.boutique.Container
import com.boutique.commons.AuthenticationException
import com.boutique.dao.CrudDAO
import com.boutique.entities.User
import com.boutique.services.user.internal.Authenticator

/**
 * @ClassName: UserServiceTest
 * @Description: TODO
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-15 上午9:39:06
 * @version: V1.0
 */
class UserServiceTest {
	
	private var userService: UserService  = Container.getInstance().getService(classOf[UserService])
	private var authenticator: Authenticator = Container.getInstance().getService(classOf[Authenticator])
	private var crudDao: CrudDAO  = Container.getInstance().getService(classOf[CrudDAO])
	
	@Test
	def testFind() = {
	   var list = crudDao.find("from User u")
	   Assert.assertTrue(list.isEmpty)
	}
	
	@Test
	def testSave() = {
		var user = new User
		user.username = "fangjie"
		user.password = "123456"
		userService.save(user)
		Assert.assertNotNull(user.id)
	}

	@Test
	def testLogin() = {
		var user = authenticator.login("fangjie", "12345")
		Assert.assertEquals(null, user)
	}
	
}