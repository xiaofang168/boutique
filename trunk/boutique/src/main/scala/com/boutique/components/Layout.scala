
package com.boutique.components

import org.apache.tapestry5.annotations.Import
import org.apache.tapestry5.annotations.Parameter
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.ioc.annotations.Inject
import com.boutique.entities.User
import com.boutique.services.user.internal.Authenticator
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
  "context:/static/js/jquery.min.js",
  "context:/static/js/bootstrap.min.js",
  "context:/static/js/CustomError.js"))
class Layout {
  
  @Property
  @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
  private var pageTitle: String = _

  @Inject
  private var authenticator: Authenticator = _
  
  def getUser(): User = {
    if (authenticator.isLoggedIn()) authenticator.getLoggedUser() else null
  }
  
}