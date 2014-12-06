/**
 * @FileName: NoValidationBubbles.scala
 * @Prject:boutique
 * @Package: com.boutique.pages
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-16
 * @version: V1.0
 */
package com.boutique.pages

import org.apache.tapestry5.annotations.Property
import org.apache.tapestry5.annotations.Persist
import org.apache.tapestry5.PersistenceConstants

/**
 * @ClassName: NoValidationBubbles
 * @Description: TODO
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午2:14:21
 * @version: V1.0
 */
class NoValidationBubbles {
  
    @Property
    @Persist(PersistenceConstants.FLASH)
    private var firstName: String = _

    @Property
    @Persist(PersistenceConstants.FLASH)
    private var lastName: String = _
}