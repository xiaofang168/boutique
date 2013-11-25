
package com.boutique.components

import org.apache.tapestry5.annotations.Import
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.ComponentResources
import com.boutique.services.user.internal.Authenticator
import com.boutique.entities.User
import org.apache.tapestry5.annotations.Log
import com.boutique.pages.Index

/**
 * @ClassName: Layout
 * @Description: 页面布局
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-14 下午4:17:44
 * @version: V1.0
 */
@Import(library = Array(
  "context:/static/js/bootstrap.min.js",
  "context:/static/js/jquery.min.js",
  "context:/static/js/CustomError.js"))
class Layout {

  @Property
  private var pageName: String = _

  @Inject
  private var resources: ComponentResources = _

  @Inject
  private var authenticator: Authenticator = _

  def getClassForPageName(): String = {
    if (resources.getPageName().equalsIgnoreCase(pageName)) "current_page_item" else null
  }

  def getUser(): User = {
    if (authenticator.isLoggedIn()) authenticator.getLoggedUser() else null
  }

  @Log
  def onActionFromLogout(): Object = {
    authenticator.logout()
    return classOf[Index]
  }
}