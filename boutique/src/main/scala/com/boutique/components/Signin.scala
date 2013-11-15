
package com.boutique.components

import org.apache.tapestry5.annotations.Component
import org.apache.tapestry5.annotations.Log
import org.apache.tapestry5.annotations.Persist
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.corelib.components.Form
import org.apache.tapestry5.ioc.Messages
import org.apache.tapestry5.ioc.annotations.Inject

import com.boutique.pages.Index
import com.boutique.services.user.UserService

/**
 * @ClassName: Signin
 * @Description: 登录页面
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-15 上午10:34:01
 * @version: V1.0
 */
class Signin {

  @Inject
  private var userService: UserService = _

  @Property
  @Persist
  private var username: String = _

  @Property
  private var password: String = _

  @Component
  private var loginForm: Form = _

  @Inject
  private var messages: Messages = _

  @Log
  def onSubmitFromLoginForm(): Object = {
    var user = userService.login(username, password)
    if (user == null) {
      loginForm.recordError(messages.get("error.login"));
      return null;
    }
    return classOf[Index]
  }
  
}