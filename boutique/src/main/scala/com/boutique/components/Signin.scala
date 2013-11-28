
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
import org.apache.tapestry5.PersistenceConstants
import org.apache.tapestry5.corelib.components.TextField
import org.apache.tapestry5.services.Request
import com.boutique.AppConstant

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

  @Inject
  private var request: Request = _
  
  @Component(id = "loginForm")
  private var form: CustomForm = _

  @Property
  @Persist(PersistenceConstants.FLASH)
  private var username: String = _

  @Component(id = "username")
  private var usernameField: TextField = _

  @Property
  private var password: String = _

  @Inject
  private var messages: Messages = _

  def onValidateFromLoginForm() {
    // Error if the names don't contain letters only
    if (username != null) {
      if (!username.matches("[A-Za-z]+")) {
        form.recordError(usernameField, "Username must contain letters only");
      }
    }
  }

  @Log
  def onSubmitFromLoginForm(): Object = {
    var user = userService.login(username, password)
    request.getSession(false).setAttribute(AppConstant.USER_INFO,user)
    return classOf[Index]
  }

}