/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Title: ProductServiceImpl.scala
 * @Prject: boutique
 * @Package: com.boutique.services.product
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-10
 * @version: V1.0
 */
package com.boutique.services.product.internal

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.boutique.services.product.ProductService

/**
 * @ClassName: ProductServiceImpl
 * @Description: 产品服务类实现
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @time: 下午5:03:48
 * @version: V1.0
 */
class ProductServiceImpl extends ProductService{
  
  private var logger:Logger = LoggerFactory.getLogger(classOf[ProductServiceImpl])
  
  def checkimageType(value:String):String ={
     logger.debug("dwr call!")
     return null
  }

}