/**
 * Copyright © 2013 杭州海康威视数字技术股份有限公司  All rights reserved.
 * @Title: AbstractMyApplicationTest.scala
 * @Prject: boutique
 * @Package: com.boutique.services
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-5 下午2:54:27
 * @version: V1.0
 */
package com.boutique

import com.boutique.services.AppModule
import com.formos.tapestry.testify.core.TapestryTester
import com.formos.tapestry.testify.junit4.TapestryTest

/**
 * @ClassName: AbstractMyApplicationTest
 * @Description: TODO
 * @author: 方杰  mailto:fangjie1@hikvision.com.cn
 * @date: 2013-11-5 下午2:54:27
 * @version: V1.0
 */
class AbstractMyApplicationTest extends TapestryTest{
  
	val SHARED_TESTER:TapestryTester = new TapestryTester("test", AppModule.getClass());
    
	def this(tt:TapestryTester) {
		this
		//super(tt)
    }
	

    def AbstractMyApplicationTest() {
       
    }    
  
}