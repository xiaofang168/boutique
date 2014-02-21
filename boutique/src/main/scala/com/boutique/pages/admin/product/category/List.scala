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

import com.boutique.entities.GoodsCate
import org.apache.tapestry5.annotations.Property
import com.boutique.dao.CrudDAO
import org.apache.tapestry5.ioc.annotations.Inject

/**
 * @ClassName: List
 * @Description: 产品列表
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2014-2-13 下午3:57:17
 * @version: V1.0
 */
class List {
  
  @Property
  private var goodsCateList:scala.collection.immutable.List[GoodsCate] = _
  
  @Property
  private var goodsCate:GoodsCate = _
  
  @Inject
  private var crudDao:CrudDAO = _
  
  def setupRender()={
    goodsCateList = crudDao.find("from GoodsCate o").asInstanceOf[scala.collection.immutable.List[GoodsCate]]
  }

}