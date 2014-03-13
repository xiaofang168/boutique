package com.boutique.pages

import org.apache.tapestry5.annotations.SessionState
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Request

import com.boutique.entities.User
import com.boutique.services.user.UserService

import javax.persistence.Entity
import javax.persistence.Table

class Index {

  @SessionState
  private var user: User = _

  @Inject
  private var request: Request = _

  @Inject
  private var userService: UserService = _

}