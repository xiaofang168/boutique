package com.boutique.services

import org.apache.tapestry5.ioc.ServiceBinder

import com.boutique.services.user.UserService
import com.boutique.services.user.internal.Authenticator
import com.boutique.services.user.internal.UserServiceImpl

/**
 * @ClassName: UserModule
 * @Description: 用户module
 * @author:  <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-4 下午7:37:49
 * @version: V1.0
 */
class UserModule {}
object UserModule {

  def bind(binder: ServiceBinder) {
    binder.bind(classOf[UserService], classOf[UserServiceImpl])
    binder.bind(classOf[Authenticator])
  }
  
}