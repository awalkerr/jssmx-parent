package com.jssmx.manage.web.controller.base;

import com.jssmx.common.utility.PageData;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    private static final long serialVersionUID = 6357869213649815390L;
    protected Logger logger = Logger.getLogger(this.getClass());

    /**
     * new PageData对象
     * @return
     */
    protected PageData getPageData(){
        return new PageData(getRequest());
    }

    /**
     * 得到request对象
     * @return
     */
    public HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }






}
