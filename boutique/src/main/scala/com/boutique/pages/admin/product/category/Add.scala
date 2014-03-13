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

import org.apache.commons.lang.StringUtils
import org.apache.tapestry5.annotations.Component
import org.apache.tapestry5.annotations.Environmental
import org.apache.tapestry5.annotations.InjectComponent
import org.apache.tapestry5.annotations.OnEvent
import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.beaneditor.Validate
import org.apache.tapestry5.corelib.components.TextField
import org.apache.tapestry5.hibernate.annotations.CommitAfter
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Request
import org.apache.tapestry5.services.javascript.JavaScriptSupport
import org.apache.tapestry5.upload.services.UploadedFile
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.boutique.components.CustomForm
import com.boutique.dao.CrudDAO
import com.boutique.entities.GoodsCate
import javax.validation.constraints.NotNull
import org.apache.tapestry5.EventConstants
import org.apache.tapestry5.annotations.SessionAttribute
import org.apache.tapestry5.annotations.Persist
import org.apache.tapestry5.PersistenceConstants
import org.apache.tapestry5.annotations.Import
import org.apache.tapestry5.ioc.Messages
/**
 * @ClassName: Add
 * @Description: 添加产品
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-2-13 下午3:58:31
 * @version: V1.0
 */
@Import(
    stylesheet=Array[String]("context:static/kindeditor/themes/default/default.css"),
    library=Array[String]("context:static/kindeditor/kindeditor-min.js",
		"context:static/kindeditor/lang/zh_CN.js",
		"context:static/js/utils.js",
		"classpath:com/boutique/pages/admin/product/category/Add.js"
))
class Add {
  
  private var logger:Logger = LoggerFactory.getLogger(classOf[Add])
  
  @Environmental
  private var javaScriptSupport: JavaScriptSupport = _
  
  @Inject
  private var request: Request = _ 
  
  @Inject
  private var dao:CrudDAO = _
  
  @Component(id = "categoryForm")
  private var form: CustomForm = _
  
  @Property
  private var gc:GoodsCate = new GoodsCate()
  

  @InjectComponent("nameKey")
  private var nameKeyField: TextField = _
  
  @Inject
  private var messages: Messages = _
  
  @Property
  private var file: UploadedFile = _
  
  @Property
  @NotNull(message="{notnull}")
  @Validate("required,maxlength=8")
  private var nameKey: String = _
  
  @SessionAttribute("locale")
  @Property
  private var locale:String = _
  
  def setupRender() {
	  	logger.debug(locale)
	  	javaScriptSupport.importJavaScriptLibrary(request.getContextPath()+"/dwr/interface/productServiceJs.js")
	  	javaScriptSupport.importJavaScriptLibrary(request.getContextPath()+"/dwr/util.js")
	  	javaScriptSupport.importJavaScriptLibrary(request.getContextPath()+"/dwr/engine.js")
  }
  
  def onValidateFromCategoryForm() {
    if (StringUtils.isBlank(gc.nameKey)) {
        form.recordError(nameKeyField, messages.get("nameKey-required-message"));
    }
  }
  
  @OnEvent(value = EventConstants.SUCCESS, component = "categoryForm")
  def onSubmitFromCategoryForm(): Object = {
    dao.save(gc)
    return classOf[Add]
  }
  
  
}