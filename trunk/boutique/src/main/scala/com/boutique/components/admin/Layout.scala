
package com.boutique.components.admin

import org.apache.tapestry5.annotations.Import
import org.apache.tapestry5.annotations.Parameter
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.ioc.annotations.Inject
import com.boutique.entities.User
import com.boutique.services.user.internal.Authenticator
import org.apache.tapestry5.BindingConstants
import org.slf4j.LoggerFactory
import org.slf4j.Logger
import org.apache.tapestry5.ioc.annotations.Symbol
import org.apache.tapestry5.SymbolConstants
import org.apache.tapestry5.annotations.SessionState
import org.apache.tapestry5.annotations.SessionAttribute
import com.boutique.AppConstant
import com.boutique.AppConstantJava

/**
 * @ClassName: Layout
 * @Description: 页面布局
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-14 下午4:17:44
 * @version: V1.0
 */
@Import(library = Array(
  "context:/static/js/bootstrap.min.js",
  "context:/static/js/CustomError.js"))
class Layout {
  
  private var logger:Logger = LoggerFactory.getLogger(classOf[Layout])
  
  @Symbol(SymbolConstants.SUPPORTED_LOCALES)
  @Inject
  private var locales:String = _
  
  @Property
  @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
  private var pageTitle: String = _

  @Inject
  private var authenticator: Authenticator = _
  
  @SessionAttribute(AppConstant.USER_INFO)
  private var user: User = _

  // 获取用户对象，判断用户是否登录
  def getUser(): User = {
		return user
  }
  
}