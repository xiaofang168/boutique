
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
import org.apache.tapestry5.annotations.SessionState
import com.boutique.entities.User
import org.slf4j.LoggerFactory
import org.slf4j.Logger
import com.boutique.services.user.internal.Authenticator

/**
 * @ClassName: Signin
 * @Description: 登录页面
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-15 上午10:34:01
 * @version: V1.0
 */
class Signin {
  private var logger:Logger = LoggerFactory.getLogger(classOf[Signin])
  
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
  
  @Inject
  private var authenticator: Authenticator = _
  
  @Property
  @Persist(PersistenceConstants.FLASH)
  private var signinError:Boolean= _

  def onValidateFromLoginForm() {
    if (username != null) {
      if (!username.matches("^([A-Za-z]|[\\d])*$")) {
        signinError=true
        form.recordError(usernameField, messages.get("error.username"));
      }
    }
  }

  @Log
  def onSubmitFromLoginForm(): Object = {
    authenticator.login(username, password)
    return classOf[Index]
  }

}