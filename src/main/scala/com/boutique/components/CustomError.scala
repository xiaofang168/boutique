/**
 * @FileName: CustomError.scala
 * @Prject:boutique
 * @Package: com.boutique.components
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-16
 * @version: V1.0
 */

package com.boutique.components

import org.apache.tapestry5.annotations.Import
import org.apache.tapestry5.Field
import org.apache.tapestry5.annotations.Parameter
import org.apache.tapestry5.services.Heartbeat
import org.apache.tapestry5.annotations.Environmental
import org.apache.tapestry5.dom.Element
import org.apache.tapestry5.MarkupWriter
import org.apache.tapestry5.BindingConstants
/**
 * @ClassName: CustomError
 * @Description: 自定义错误组件
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午1:34:03
 * @version: V1.0
 */
@Import(library = Array[String]("context:/static/js/CustomError.js"))
class CustomError {
	// Parameters
    
    /**
     * The for parameter is used to identify the {@link Field} linked to this label (it is named this way because it
     * results in the for attribute of the label element).
     */
    @Parameter(name = "for", required = true, allowNull = false, defaultPrefix = BindingConstants.COMPONENT)
    private var field: Field = _
    
    // Generally useful bits and pieces

    @Environmental
    private var heartbeat: Heartbeat = _

    private var labelElement: Element = _
    
    // The code

    def beginRender(writer: MarkupWriter): Boolean = {
        val field: Field  = this.field

        labelElement = writer.element("span", "class", "msg")

        // Since we don't know if the field has rendered yet, we need to defer writing the for and id
        // attributes until we know the field has rendered (and set its clientId property). That's
        // exactly what Heartbeat is for.

        var command: Runnable  = new Runnable() {
            def run() {
                var fieldId = field.getClientId()
                labelElement.forceAttributes("id", fieldId + "-msg")
            }
        }

        heartbeat.defer(command)

        // Return false to prevent the body being rendered
        return false
    }

    def afterRender(writer: MarkupWriter ) {
        writer.end()
    }
}