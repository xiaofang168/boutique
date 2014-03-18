
package com.boutique.components

import org.apache.tapestry5.annotations.Component
import org.apache.tapestry5.annotations.OnEvent
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.beaneditor.Validate
import org.apache.tapestry5.ioc.Messages
import org.apache.tapestry5.ioc.annotations.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.boutique.dao.CrudDAO
import com.boutique.entities.User
import com.boutique.pages.Index
import com.boutique.services.user.UserService
import com.boutique.services.user.internal.Authenticator
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import org.apache.tapestry5.EventConstants
import org.apache.tapestry5.annotations.Persist
import org.apache.tapestry5.PersistenceConstants
import org.apache.tapestry5.annotations.InjectPage
import com.boutique.AppConstant
import org.apache.tapestry5.annotations.SessionAttribute

/**
 * @ClassName: 注册组件
 * @Description: TODO
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-28 下午1:54:36
 * @version: V1.0
 */
class Signup {

  private var logger:Logger = LoggerFactory.getLogger(classOf[Signup])
   
  @Property
  @NotNull(message="{notnull}")
  @Size(min=3,max=10,message="{usernameSize}")
  @Pattern(regexp="^([A-Za-z]|[\\d])*$",message="{usernameRegexp}")
  private var username: String = _

  @Property
  @Validate("required,email")
  private var email: String = _

  @Property
  @Validate("password")
  private var password: String = _

  @Property
  @Validate("password")
  private var confirmPassword: String = _

  @Inject
  private var userService: UserService = _

  @Inject
  private var crudDao: CrudDAO = _

  @Component(id = "registerForm")
  private var form: CustomForm = _

  @Inject
  private var messages: Messages = _

  @Inject
  private var authenticator: Authenticator = _
  
  @SessionAttribute("userInfo")
  private var user: User = _
  
  @InjectPage 
  private var index:Index = _

  @OnEvent(value = EventConstants.VALIDATE, component = "registerForm")
  def checkForm() {
    if (!confirmPassword.equals(password)) {
      form.recordError(messages.get("error.verifypassword"));
    }
  }

  @OnEvent(value = EventConstants.SUCCESS, component = "RegisterForm")
  def proceedSignup(): Object = {
    var userVerif = crudDao.find("from User u where u.username=? and u.email=?", Array(username, email))
    logger.debug("userVerif"+userVerif)
    if (!userVerif.isEmpty) {
      form.recordError(messages.get("error.userexists"))
      return index
    }
    user = new User
    user.username = username
    user.password = password
    user.email = email
    userService.save(user)
    return index
  }
  
  def onFailure() = {
    index.errorAction = AppConstant.SIGNUP_ACTION
    logger.debug("Signup fail!")
  }

}