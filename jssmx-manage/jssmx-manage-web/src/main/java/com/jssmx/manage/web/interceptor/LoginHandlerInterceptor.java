package com.jssmx.manage.web.interceptor;

import com.jssmx.manage.pojo.system.User;
import com.jssmx.manage.web.utility.Const;
import com.jssmx.manage.web.utility.Jurisdiction;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        if(path.matches(Const.NO_INTERCEPTOR_PATH)){
            return true;
        }else {
            User user = (User) Jurisdiction.getSession().getAttribute(Const.SESSION_USER);
            if(user != null){
                path = path.substring(1);
                boolean b = Jurisdiction.menuJurisdiction(path);
                if(!b){
                    response.sendRedirect(request.getContextPath() + Const.LOGIN);
                }
                return b;
            }else {
                response.sendRedirect(request.getContextPath() + Const.LOGIN);
                return false;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
