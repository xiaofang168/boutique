/**
 * @FileName: CustomForm.scala
 * @Prject:boutique
 * @Package: com.boutique.components
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-16
 * @version: V1.0
 */
package com.boutique.components

import org.apache.tapestry5.ClientElement
import org.apache.tapestry5.FormValidationControl
import org.apache.tapestry5.FormValidationControl
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Environment
import org.apache.tapestry5.annotations.Component
import org.apache.tapestry5.corelib.components.Form
import org.apache.tapestry5.MarkupWriter
import org.apache.tapestry5.ValidationDecorator
import com.boutique.commons.CustomValidationDecorator
import org.apache.tapestry5.Field

/**
 * @ClassName: CustomForm
 * @Description: CustomForm simply wraps a Form so it can introduce our own custom validation decorator in place of the default one.
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 下午2:02:05
 * @version: V1.0
 */
class CustomForm extends ClientElement with FormValidationControl{
	// Generally useful bits and pieces

    @Inject
    private var environment: Environment = _ 

    @Component(publishParameters = "context, tracker, clientValidation, autoFocus, zone, secure, validationId, validate, class", 
            inheritInformalParameters = true)
    private var form: Form = _

    // The code

    /**
     * This beginRender() will execute before our inner form's beginRender(). It gives us the chance to change the
     * environment first - let's push our custom validation decorator onto the environment stack.
     */
    def beginRender(writer: MarkupWriter) {
        environment.push(classOf[ValidationDecorator], new CustomValidationDecorator(environment, writer))
    }

    /**
     * This afterRender() will execute after our inner form's beginRender(). Let's undo what we did in beforeRender().
     */
    def afterRender(writer: MarkupWriter) {
        environment.pop(classOf[ValidationDecorator]);
    }

    /**
     * Returns the client id of the embedded form.
     */
    
    override def  getClientId(): String ={
        return form.getClientId()
    }

  
    override def clearErrors() {
        form.clearErrors()
    }


    override def getHasErrors(): Boolean = {
        return form.getHasErrors();
    }

    
    override def isValid(): Boolean = {
        return form.isValid();
    }

    
    override def recordError(errorMessage: String) {
        form.recordError(errorMessage)
    }


    override def recordError(field: Field, errorMessage: String ) {
        form.recordError(field, errorMessage);
    }
}