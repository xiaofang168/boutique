/**
 * @Title: Login.scala
 * @Prject: boutique
 * @Package: com.boutique.pages.admin
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-2-13 上午11:04:55
 * @version: V1.0
 */
package com.boutique.pages.admin

import org.apache.tapestry5.annotations.Component
import org.apache.tapestry5.annotations.Persist
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.annotations.SessionState
import org.apache.tapestry5.beaneditor.Validate
import org.apache.tapestry5.ioc.annotations.Inject
import com.boutique.components.CustomForm
import com.boutique.entities.User
import com.boutique.services.user.UserService
import javax.persistence.Entity
import javax.persistence.Table
import org.apache.tapestry5.PersistenceConstants

/**
 * @ClassName: Login
 * @Description: TODO
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-2-13 上午11:04:55
 * @version: V1.0
 */
class Login {

  @Inject
  private var userService: UserService = _
  
  @Component(id = "loginForm")
  private var form: CustomForm = _
  
  @SessionState(create=false)
  private var user: User = _
  
  @Property
  @Validate("required,email")
  private var email: String = _
  
  @Property
  @Persist(PersistenceConstants.FLASH)
  private  var remember:Boolean = _

  @Property
  @Validate("password")
  private var password: String = _
  
  def onSubmitFromLoginForm(): Object = {
    user = userService.login(email, password)
    return classOf[Index]
  }
  
}