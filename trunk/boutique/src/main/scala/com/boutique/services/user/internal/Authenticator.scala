
package com.boutique.services.user.internal

import org.apache.tapestry5.services.Request
import org.apache.tapestry5.ioc.annotations.Inject
import org.apache.tapestry5.services.Session
import com.boutique.AppConstant

/**
 * @ClassName: Authenticator
 * @Description: 认证类
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @date: 2013-11-15 上午10:21:42
 * @version: V1.0
 */
class Authenticator {
    
	@Inject
    private var request: Request = _
    
    def isLoggedIn(): Boolean = {
        var session = request.getSession(false)
        if (session != null) { return session.getAttribute(AppConstant.USER_INFO) != null }
        return false;
    }
}