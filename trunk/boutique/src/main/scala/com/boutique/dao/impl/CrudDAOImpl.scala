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
import com.boutique.AppConstant
import scala.collection.JavaConverters._
import scala.collection.mutable.Buffer
import scala.collection.convert.Decorators
import org.hibernate.Query
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
    session.persist(t)
    session.flush();
    session.refresh(t);
    return t;
  }

  def get[T, PK <: java.io.Serializable](clType: Class[T], id: PK): T = {
    session.get(clType, id).asInstanceOf
  }

  def find[T](hql: String): List[T] = {
    var query = session.createQuery(hql)
    query.setCacheable(AppConstant.EHCACH_EABLE)
    var list: java.util.List[T] = query.list().asInstanceOf[java.util.List[T]]
    return scala.collection.JavaConversions.asScalaBuffer(list).toList
  }

  def find(hql: String, params: Array[Object]): List[_] = {
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
    query.setCacheable(AppConstant.EHCACH_EABLE);
    scala.collection.JavaConversions.asScalaBuffer(query.list()).toList
  }
}
	
	