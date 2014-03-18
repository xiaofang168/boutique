
package com.boutique.services.user.internal

import org.apache.tapestry5.ioc.annotations.Inject

import com.boutique.commons.AuthenticationException
import com.boutique.dao.CrudDAO
import com.boutique.entities.User

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

  @throws(classOf[AuthenticationException])
  def login(username: String, password: String):User = {
    var user = crudao.findUnique[User]("from User u where u.username = ? or u.email=? and u.password = ?", Array(username, username, password))
    return user
  }

}