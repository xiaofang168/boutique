package com.boutique.pages

import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.annotations.SessionAttribute
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Request
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.boutique.entities.User
import com.boutique.services.user.UserService

class Index {

  private var logger:Logger = LoggerFactory.getLogger(classOf[Index])
   
  @SessionAttribute("userInfo")
  private var user: User = _

  @Inject
  private var request: Request = _

  @Inject
  private var userService: UserService = _
  
  @Property
  var errorAction:String = _
  
  def onPassivate():String = { 
	return errorAction
  } 
  
  def onActivate(errorAction:String) {
    this.errorAction = errorAction
    logger.debug(this.errorAction)
  }

}