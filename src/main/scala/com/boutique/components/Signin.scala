
package com.boutique.components

import org.apache.tapestry5.annotations.Component
import org.apache.tapestry5.annotations.InjectPage
import org.apache.tapestry5.annotations.Log
import org.apache.tapestry5.annotations.Persist
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.annotations.SessionAttribute
import org.apache.tapestry5.corelib.components.TextField
import org.apache.tapestry5.ioc.Messages
import org.apache.tapestry5.ioc.annotations.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.boutique.AppConstant
import com.boutique.entities.User
import com.boutique.pages.Index
import com.boutique.services.user.UserService
import com.boutique.services.user.internal.Authenticator
import org.apache.tapestry5.PersistenceConstants

/**
 * @ClassName: Signin
 * @Description: 登录页面
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-15 上午10:34:01
 * @version: V1.0
 */
class Signin {
  private var logger: Logger = LoggerFactory.getLogger(classOf[Signin])

  @Inject
  private var userService: UserService = _

  @SessionAttribute("userInfo")
  private var user: User = _

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

  @InjectPage
  private var index: Index = _

  def onValidateFromLoginForm() {
    if (username != null) {
      if (!username.matches("^([A-Za-z]|[\\d])*$")) {
        form.recordError(usernameField, messages.get("error.username"));
      }
    }
  }

  @Log
  def onSubmitFromLoginForm(): Object = {
    user = authenticator.login(username, password)
    if (user == null) {
      index.errorAction = AppConstant.SIGNIN_ACTION
      form.recordError(messages.get("signinError"));
    }
    return index
  }

  def onSuccess() = {
    index.errorAction = null
    logger.debug("Signin success!")
  }

  def onFailure() = {
    index.errorAction = AppConstant.SIGNIN_ACTION
    logger.debug("Signin fail!")
  }

}