/**
 * Copyright © 2014 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: GoodsCate.scala
 * @Prject: boutique
 * @Package: com.boutique.entities
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2014-2-14 下午2:15:41
 * @version: V1.0
 */
package com.boutique.entities

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.Column

/**
 * @ClassName: GoodsCate
 * @Description: TODO
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2014-2-14 下午2:15:41
 * @version: V1.0
 */
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name = "goods_cate")
class GoodsCate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private var id: Long = _;
  
  private var pid: Long = _;
  
  @Column(nullable = false)
  private var nameKey: String = _;
  
  private var descriptionTxtkey: String = _;
  private var metaTitleKey: String = _;
  private var metaKeywordsTxtkey: String = _;
  private var metaDescriptionTxtkey: String = _;
  private var urlkey: String = _;
  private var image: String = _;
  private var sortOrder: Integer = _;
  
}