/**
 * Copyright © 2014 fangjie All rights reserved.
 * @Description:
 * @Title: ListTest.scala
 * @Prject: boutique
 * @Package: com.boutique.pages.admin.product.category
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2014-3-21
 * @version: V1.0
 */
package com.boutique.pages.admin.product.category

import com.boutique.dao.CrudDAO
import com.boutique.Container
import org.junit.Test
import com.boutique.entities.GoodsCate
import org.junit.Assert

/**
 * @ClassName: ListTest
 * @Description:
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午5:36:08
 * @version: V1.0
 */
class ListTest {
  
    private var crudDao: CrudDAO  = Container.getInstance().getService(classOf[CrudDAO])
    
    @Test
	def save() {
      var gc = new GoodsCate()
      gc.nameKey="test"
      crudDao.save(gc)
    }
    
    @Test
    def find(){
      save
      var list = crudDao.find("from GoodsCate gc")
      Assert.assertEquals(1, list.size())
    }
}