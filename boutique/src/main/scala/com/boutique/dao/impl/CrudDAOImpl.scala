/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: CrudDAO.scala
 * @Prject: boutique
 * @Package: com.boutique.dao.impl
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:49:26
 * @version: V1.0
 */
package com.boutique.dao.impl

import com.boutique.dao.CrudDAO
import org.hibernate.Session
import org.apache.tapestry5.ioc.annotations.Inject
import com.boutique.entities.User

/**
 * @ClassName: CrudDAO
 * @Description: 增删改查dao服务实现类
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:49:26
 * @version: V1.0
 */
class  CrudDAOImpl extends CrudDAO {
  
	@Inject
	var session: Session = _
    
	def save[T](t: T):T = {
			session.persist(t)
			session.flush();
			session.refresh(t);
			return t;
	}
	
	def find[T, PK  <: Serializable](clType: Class[T], id: PK ):T = {
	   session.get(clType, id).asInstanceOf
	}
	
}