package com.boutique.services.user

import org.apache.tapestry5.hibernate.annotations.CommitAfter

import com.boutique.entities.User

import javax.persistence.Entity
import javax.persistence.Table

/**
 * @ClassName: UserService
 * @Description: 用户服务类
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午7:20:42
 * @version: V1.0
 */
trait UserService {

  /**
   * @param user
   * @return persisted User
   */
  @CommitAfter
  def save(user: User): User
  
}