package com.jssmx.web.interceptor;

import com.jssmx.common.utility.CookieUtils;
import com.jssmx.web.pojo.User;
import com.jssmx.web.service.PropertiesService;
import com.jssmx.web.service.UserService;
import com.jssmx.web.threadlocal.UserThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    public static final String COOKIE_NAME = "JSSMX_TOKEN";
    @Autowired
    private PropertiesService propertiesService;
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserThreadLocal.set(null);//清空当前线程中的User对象

        String loginUrl=propertiesService.JSSMX_SSO_URL+"/user/login";
        String token = CookieUtils.getCookieValue(request,COOKIE_NAME);
        if(StringUtils.isEmpty(token)){
            response.sendRedirect(loginUrl);
            return false;
        }

        User user=userService.queryUserByToken(token);
        if(null==user){
            response.sendRedirect(loginUrl);
            return false;
        }

        UserThreadLocal.set(user);//将user对象放入
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
