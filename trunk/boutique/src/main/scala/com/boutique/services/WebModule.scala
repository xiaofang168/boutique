/**
 * @FileName: WebModule.scala
 * @Prject:boutique
 * @Package: com.boutique.services
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-16
 * @version: V1.0
 */
package com.boutique.services

import org.apache.tapestry5.ioc.annotations.Contribute
import org.apache.tapestry5.ioc.MappedConfiguration
import org.apache.tapestry5.validator.ValidatorMacro

/**
 * @ClassName: WebModule
 * @Description: web module
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午4:39:42
 * @version: V1.0
 */
class WebModule{}
object WebModule {
	
  @Contribute(classOf[ValidatorMacro])
  def combineValidators(configuration: MappedConfiguration[String, String]) {
    configuration.add("username", "required, minlength=3, maxlength=15")
    configuration.add("password", "required, minlength=6, maxlength=12")
  }

}