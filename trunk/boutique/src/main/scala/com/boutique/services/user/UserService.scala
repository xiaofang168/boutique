package com.boutique.services.user

import com.boutique.entities.User

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
  def save(user: User): User
  
   /**
   * @param username 用户名
   * @return password 密码
   * return ture/false Boolean
   */
  def login(username:String, password:String):Boolean
}