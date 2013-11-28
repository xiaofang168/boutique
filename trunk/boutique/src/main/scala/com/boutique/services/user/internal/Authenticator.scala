
package com.boutique.services.user.internal

import org.apache.tapestry5.services.Request
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Session
import com.boutique.AppConstant
import com.boutique.entities.User
import com.boutique.commons.AuthenticationException
import com.boutique.dao.CrudDAO

/**
 * @ClassName: Authenticator
 * @Description: 认证类
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-15 上午10:21:42
 * @version: V1.0
 */
class Authenticator {

  @Inject
  private var crudao: CrudDAO = _

  @Inject
  private var request: Request = _

  def isLoggedIn(): Boolean = {
    var session = request.getSession(false)
    if (session != null) { return session.getAttribute(AppConstant.USER_INFO) != null }
    return false;
  }

  def logout() {
    var session = request.getSession(false)
    if (session != null) {
      session.setAttribute(AppConstant.USER_INFO, null)
      session.invalidate()
    }
  }

  @throws(classOf[AuthenticationException])
  def login(username: String, password: String) {
    var user = crudao.findUnique("from User u where u.username=? and u.password=?", Array(username, password))
    if (user == null) {
      throw new AuthenticationException("The user doesn't exist")
    }
    request.getSession(true).setAttribute(AppConstant.USER_INFO, user)
  }

  def getLoggedUser(): User = {
    var user: User = null
    if (isLoggedIn()) {
      user = request.getSession(true).getAttribute(AppConstant.USER_INFO).asInstanceOf[User]
    } else {
      throw new IllegalStateException("The user is not logged ! ")
    }
    return user
  }

}