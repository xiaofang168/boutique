/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: UserService.scala
 * @Prject: boutique
 * @Package: com.boutique.services
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午7:20:42
 * @version: V1.0
 */
package com.boutique.services.user

import com.boutique.entities.User
import org.apache.tapestry5.hibernate.annotations.CommitAfter
import com.boutique.dao.CrudDAO
import javax.persistence.Entity
import javax.persistence.Table
import org.apache.tapestry5.ioc.annotations.Inject

/**
 * @ClassName: UserService
 * @Description: 用户服务类
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午7:20:42
 * @version: V1.0
 */
class UserService {

  @Inject
  var crudDao:CrudDAO = _
  
  @CommitAfter
  def saved(user:User):User ={
    return crudDao.save(user)
  }
  
}