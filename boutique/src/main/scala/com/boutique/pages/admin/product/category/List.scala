/**
 * Copyright © 2014 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: List.scala
 * @Prject: boutique
 * @Package: com.boutique.pages.admin.product.category
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2014-2-13 下午3:57:17
 * @version: V1.0
 */
package com.boutique.pages.admin.product.category

import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.ioc.annotations.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.boutique.dao.CrudDAO
import com.boutique.entities.GoodsCate

import javax.persistence.Entity
import javax.persistence.Table

/**
 * @ClassName: List
 * @Description: 产品列表
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2014-2-13 下午3:57:17
 * @version: V1.0
 */
class List {
  
  private var logger:Logger = LoggerFactory.getLogger(classOf[List])
  
  @Property
  private var goodsCateList:java.util.List[GoodsCate] = _
  
  @Property
  private var goodsCate:GoodsCate = _
  
  @Inject
  private var crudDao:CrudDAO = _
  
  def setupRender()={
    goodsCateList = crudDao.find("from GoodsCate o").asInstanceOf[java.util.List[GoodsCate]]
    logger.debug("goodsCateList size:"+goodsCateList.size)
  }

}