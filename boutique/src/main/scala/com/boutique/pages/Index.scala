package com.boutique.pages

import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Request

import com.boutique.AppConstant
import com.boutique.entities.User
import com.boutique.services.user.UserService

class Index {

  @Property
  private var user: User = _

  @Inject
  private var request: Request = _

  @Inject
  private var userService: UserService = _

  def setupRender() {
    var session = request.getSession(false)
    if (session != null) {
      if (session.getAttribute(AppConstant.USER_INFO) != null){
    	  user = session.getAttribute(AppConstant.USER_INFO).asInstanceOf
      }
    }
  }
}