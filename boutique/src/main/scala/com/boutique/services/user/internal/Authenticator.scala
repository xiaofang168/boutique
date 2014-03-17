
package com.boutique.services.user.internal

import org.apache.tapestry5.services.Request
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Session
import com.boutique.AppConstant
import com.boutique.entities.User
import com.boutique.commons.AuthenticationException
import com.boutique.dao.CrudDAO
import org.apache.tapestry5.annotations.SessionState
import org.apache.tapestry5.ioc.Messages
import org.apache.tapestry5.annotations.SessionAttribute

/**
 * @ClassName: Authenticator
 * @Description: 认证类
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-15 上午10:21:42
 * @version: V1.0
 */
class Authenticator {

  @Inject
  private var messages: Messages = _

  @Inject
  private var crudao: CrudDAO = _

  @SessionAttribute("userInfo")
  private var user: User = _

  def isLoggedIn(): Boolean = {
    return user != null
  }

  def logout() {
    user = null
  }

  @throws(classOf[AuthenticationException])
  def login(username: String, password: String) = {
    user = crudao.findUnique("from User u where u.username = ? or u.email=? and u.password = ?", Array(username, username, password))
    if (user == null) {
      throw new AuthenticationException(messages.get("error.usernotexists"))
    }
  }

}