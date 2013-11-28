
package com.boutique.components

import org.apache.tapestry5.annotations.Component
import org.apache.tapestry5.annotations.OnEvent
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.beaneditor.Validate
import org.apache.tapestry5.hibernate.annotations.CommitAfter
import org.apache.tapestry5.ioc.Messages
import org.apache.tapestry5.ioc.annotations.Inject
import com.boutique.commons.AuthenticationException
import com.boutique.dao.CrudDAO
import com.boutique.entities.User
import com.boutique.pages.Index
import com.boutique.services.user.UserService
import com.boutique.services.user.internal.Authenticator
import javax.persistence.Entity
import javax.persistence.Table
import org.apache.tapestry5.EventConstants

/**
 * @ClassName: 注册组件
 * @Description: TODO
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-28 下午1:54:36
 * @version: V1.0
 */
class Signup {

  @Property
  @Validate("required, minlength=3, maxlength=50")
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

  @OnEvent(value = EventConstants.VALIDATE, component = "registerForm")
  def checkForm() {
    if (!confirmPassword.equals(password)) {
      form.recordError(messages.get("error.verifypassword"));
    }
  }

  @OnEvent(value = EventConstants.SUCCESS, component = "RegisterForm")
  def proceedSignup(): Object = {
    var userVerif = crudDao.find("from User u where u.username=? and u.email=?", Array(username, email))
    if (userVerif != null) {
      form.recordError(messages.get("error.userexists"))
      return null;
    }
    var user = new User
    user.username = username
    user.password = password
    user.email = email
    userService.save(user)
    authenticator.login(username, password)
    return classOf[Index]
  }

}