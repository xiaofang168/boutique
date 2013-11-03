package com.boutique.entities

import javax.persistence.Table
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
@Table(name = "user")
class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id:Long = _
  
  @Column(nullable = false)
  @NotNull
  @Size(min = 3, max = 50)
  var username: String = _
  var realname: String = _
  var password: String = _
  var sex: String = _
  var birthdate: String = _
  var nation: String = _
  var idCard: String = _
  var email: String = _
 
  
}