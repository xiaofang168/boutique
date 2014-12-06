/**
 * @FileName: CustomValidationDecorator.scala
 * @Prject:boutique
 * @Package: com.boutique.commons
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-16
 * @version: V1.0
 */
package com.boutique.commons

import org.apache.tapestry5.BaseValidationDecorator
import org.apache.tapestry5.services.Environment
import org.apache.tapestry5.MarkupWriter
import org.apache.tapestry5.dom.Element
import org.apache.tapestry5.Field
import org.apache.tapestry5.corelib.components.RadioGroup
import org.apache.tapestry5.ValidationTracker

/**
 * @ClassName: CustomValidationDecorator
 * @Description: 自定义验证
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午1:51:21
 * @version: V1.0
 */
class CustomValidationDecorator(environment: Environment, markupWriter: MarkupWriter) extends BaseValidationDecorator{
    
   override def insideLabel(field: Field, element: Element) {
        val radioGroupClassName = classOf[RadioGroup].getName()

        if (field == null) {
            return;
        }

        if (!field.getClass().getName().equals(radioGroupClassName)) {
            if (field.isRequired()) {
                element.addClassName("required-label");
                element.getContainer().addClassName("required-label-c");
            }
        }

        if (inError(field)) {
            element.addClassName("error-label");
            element.getContainer().addClassName("error-label-c");
        }
    }

    override def insideField(field: Field) {

        if (field.isRequired()) {
            getElement().addClassName("required-field");
            getElement().getContainer().addClassName("required-field-c");
        }

        if (inError(field)) {
            getElement().addClassName("error-field");
            getElement().getContainer().addClassName("error-field-c");
        }
    }

    private def inError(field: Field): Boolean = {
        var tracker: ValidationTracker = getTracker()
        tracker.inError(field)
    }

    private def getTracker(): ValidationTracker = {
        return environment.peekRequired(classOf[ValidationTracker]);
    }

    private def getElement(): Element = {
        return markupWriter.getElement()
    }
}