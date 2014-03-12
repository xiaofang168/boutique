/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Title: SigninTest.scala
 * @Prject: boutique
 * @Package: com.boutique.services.user
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-12
 * @version: V1.0
 */
package com.boutique.services.user

import org.junit.Assert
import org.junit.Test

/**
 * @ClassName: SigninTest
 * @Description:
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @time: 下午5:14:17
 * @version: V1.0
 */
class SigninTest {
  
	@Test
	def matchPattern() = {
	  var username="haohao"
	  Assert.assertTrue(username.matches("^([A-Za-z]|[\\d])*$"))
	}
}