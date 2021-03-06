/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: CrudDAO.scala
 * @Prject: boutique
 * @Package: com.boutique.dao
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:48:36
 * @version: V1.0
 */
package com.boutique.dao

import org.apache.tapestry5.hibernate.annotations.CommitAfter


/**
 * @ClassName: CrudDAO
 * @Description: 增删改查dao服务接口
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:48:36
 * @version: V1.0
 */
trait CrudDAO {

	@CommitAfter
	def save[T](t: T):T
	
	def get[T, PK  <: java.io.Serializable](clType: Class[T], id: PK ):T
  
	def find(hql:String): java.util.List[_]
	
	def find(hql: String, params: Array[Object]):java.util.List[_]
	
	def findUnique[T](hql: String, params: Array[Object]): T
	
}