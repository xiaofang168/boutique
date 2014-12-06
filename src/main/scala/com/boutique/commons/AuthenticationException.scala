
package com.boutique.commons

import java.lang.Exception

/**
 * @ClassName: AuthenticationException
 * @Description: 用户认证异常定义
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-28 下午2:29:12
 * @version: V1.0
 */
class AuthenticationException(message: String = null, cause: Throwable = null ) extends Exception(message, cause){
	
	def this(message:String) = this (message, null) 
  
    def this(cause: Throwable) = this (null, cause)
}