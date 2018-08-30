package com.jssmx.manage.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 启动tomcat时运行此类
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("tomcat init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
