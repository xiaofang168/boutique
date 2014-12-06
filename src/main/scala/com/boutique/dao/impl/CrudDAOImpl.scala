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

import org.apache.tapestry5.ioc.annotations.Inject
import org.hibernate.Query
import org.hibernate.Session
import com.boutique.AppConstant
import com.boutique.dao.CrudDAO
import java.util.List
/**
 * @ClassName: CrudDAO
 * @Description: 增删改查dao服务实现类
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-4 下午6:49:26
 * @version: V1.0
 */
class CrudDAOImpl extends CrudDAO {

  @Inject
  var session: Session = _

  def save[T](t: T): T = {
    session.save(t)
    return t
  }

  def get[T, PK <: java.io.Serializable](clType: Class[T], id: PK): T = {
    session.get(clType, id).asInstanceOf
  }

  def find(hql: String): java.util.List[_] = {
    return find(hql, null)
  }

  def find(hql: String, params: Array[Object]): java.util.List[_] = {
    var query = setHqlQueryParameter(hql, params)
    query.setCacheable(AppConstant.EHCACH_EABLE)
    return query.list()
  }

  def findUnique[T](hql: String, params: Array[Object]): T = {
    var query = setHqlQueryParameter(hql, params)
    return query.uniqueResult().asInstanceOf[T]
  }

  private def setHqlQueryParameter(hql: String, params: Array[Object]): Query = {
    var query: Query = session.createQuery(hql)
    if (params != null) {
      for (i <- 0 until params.length) {
        if (params(i).isInstanceOf[Array[Object]]) {
          if (params(i).asInstanceOf[Array[Object]].length == 2 && (params(i).asInstanceOf[Array[Object]])(0).isInstanceOf[String]) {
            if ((params(i).asInstanceOf[Array[Object]])(1).isInstanceOf[Array[Object]]) {
              query.setParameterList((params(i).asInstanceOf[Array[Object]])(0).asInstanceOf[String], params(i).asInstanceOf[Array[Object]](1).asInstanceOf[Array[Object]]);
            } else {
              query.setParameter(params(i).asInstanceOf[Array[Object]](0).asInstanceOf[String], params(i).asInstanceOf[Array[Object]](1));
            }
          }
        } else {
          query.setParameter(i, params(i));
        }
      }
    }
    return query
  }
}
	
	