/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: UserModule.scala
 * @Prject: boutique
 * @Package: com.boutique.services
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午7:37:49
 * @version: V1.0
 */
package com.boutique.services

import com.boutique.services.user.UserService
import org.apache.tapestry5.ioc.ServiceBinder

/**
 * @ClassName: UserModule
 * @Description: TODO
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午7:37:49
 * @version: V1.0
 */
object UserModule {
  
	def bind(binder: ServiceBinder ){
        binder.bind(classOf[UserService], classOf[UserService]);
    }
}