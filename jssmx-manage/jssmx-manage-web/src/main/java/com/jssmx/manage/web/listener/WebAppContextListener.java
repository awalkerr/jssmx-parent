package com.jssmx.manage.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=========== 获取Spring WebApplicationContext");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
