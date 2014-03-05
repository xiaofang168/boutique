/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Title: Add.scala
 * @Prject: boutique
 * @Package: com.boutique.pages.admin.product.category
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-2-13 下午3:58:31
 * @version: V1.0
 */
package com.boutique.pages.admin.product.category

import com.boutique.components.CustomForm
import org.apache.tapestry5.annotations.Component
import com.boutique.entities.GoodsCate
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.annotations.OnEvent
import org.apache.tapestry5.EventConstants
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.apache.commons.lang.StringUtils
import org.apache.tapestry5.corelib.components.TextField
import org.apache.tapestry5.beaneditor.Validate
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern


/**
 * @ClassName: Add
 * @Description: 添加产品
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-2-13 下午3:58:31
 * @version: V1.0
 */
class Add {
  
  private var log:Logger = LoggerFactory.getLogger(classOf[Add])
  
  @Component(id = "categoryForm")
  private var form: CustomForm = _
  
  @Property
  private var gc:GoodsCate = new GoodsCate()
  
  @Component(id = "nameKey")
  private var nameKeyField: TextField = _
  
  @Property
  @NotNull(message="{notnull}")
  @Validate("maxlength=8")
  private var nameKey: String = _
  
  def onValidateFromCategoryForm() {
    if (StringUtils.isBlank(gc.nameKey)) {
        form.recordError(nameKeyField, "Category Name not be null!");
    }
  }
  
  @OnEvent(value = EventConstants.SUCCESS, component = "categoryForm")
  def onSubmitFromCategoryForm(): Object = {
    log.debug("nameKey:"+gc.nameKey)
    return classOf[Add]
  }
  
  
}