/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Title: ProductService.scala
 * @Prject: boutique
 * @Package: com.boutique.services.product
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-10
 * @version: V1.0
 */
package com.boutique.services.product

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @ClassName: ProductService
 * @Description: 产品服务类
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @time: 下午5:03:48
 * @version: V1.0
 */
trait ProductService {
  
  def checkimageType(value:String):String

}