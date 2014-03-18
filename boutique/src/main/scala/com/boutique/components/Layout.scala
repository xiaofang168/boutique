
package com.boutique.components

import org.apache.tapestry5.annotations.Import
import org.apache.tapestry5.annotations.Parameter
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.annotations.SessionAttribute
import com.boutique.AppConstant
import com.boutique.entities.User
import javax.persistence.Entity
import javax.persistence.Table
import org.apache.tapestry5.BindingConstants

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

  @Property
  @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
  private var pageTitle: String = _

  @Parameter
  var errorAction: String = _

  @SessionAttribute("userInfo")
  private var user: User = _

  def getSignupError(): Boolean = {
    return AppConstant.SIGNUP_ACTION.equals(errorAction)
  }

  def getSigninError(): Boolean = {
    return AppConstant.SIGNIN_ACTION.equals(errorAction)
  }

}