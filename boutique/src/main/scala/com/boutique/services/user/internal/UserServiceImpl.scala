
package com.boutique.services.user.internal

import com.boutique.services.user.UserService
import com.boutique.dao.CrudDAO
import org.apache.tapestry5.ioc.annotations.Inject
import com.boutique.entities.User

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户服务实现
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-14 下午6:26:23
 * @version: V1.0
 */
class UserServiceImpl extends UserService {

  @Inject
  var crudDao: CrudDAO = _

  def save(user: User): User = {
    return crudDao.save(user)
  }

  def login(username: String, password: String): Boolean = {
    var list = crudDao.find("from User u where u.username = ? and u.password = ?", Array(username, password))
    return !list.isEmpty
  }
  
}