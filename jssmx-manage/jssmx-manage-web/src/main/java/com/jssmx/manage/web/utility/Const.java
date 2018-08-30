package com.jssmx.manage.web.utility;

/**
 * 项目中的常量
 */
public class Const {
    public static final String SESSION_USERNAME         =   "SESSION_USERNAME";         //当前用户的用户名
    public static final String DEPARTMENT_IDS           =   "DEPARTMENT_IDS";           //当前用户拥有的最高部门权限集合
    public static final String DEPARTMENT_ID            =   "DEPARTMENT_ID";            //当前用户拥有的最高部门权限
    public static final String SESSION_QX               =   "SESSION_QX";
    public static final String SESSION_ALL_MENULIST     =   "SESSION_ALL_MENULIST";	    //全部菜单
    public static final String SESSION_MENULIST         =   "SESSION_MENULIST";		    //当前菜单
    public static final String SESSION_USER             =   "SESSION_USER";             //当前用户的用户
    public static final String SESSION_USERROL          =   "SESSION_USERROL";		    //用户对象
    public static final String SESSION_ROLE_RIGHTS      =   "SESSION_ROLE_RIGHTS";
    public static final String SESSION_USERPDS          =   "SESSION_USERPDS";


    public static final String LOGIN                    =   "/login_toLogin.do";					//登录地址
    public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(plugins)|(main)|(websocket)|(uploadImgs)).*";	//不对匹配该值的访问路径拦截（正则）



    /**
     * APP Constants
     */
    //系统用户注册接口_请求协议参数)
    public static final String[] SYSUSER_REGISTERED_PARAM_ARRAY = new String[]{"username","password","name","email","rcode"};
    public static final String[] SYSUSER_REGISTERED_VALUE_ARRAY = new String[]{"用户名","密码","姓名","邮箱","验证码"};

    //app根据用户名获取会员信息接口_请求协议中的参数
    public static final String[] APP_GETAPPUSER_PARAM_ARRAY = new String[]{"username"};
    public static final String[] APP_GETAPPUSER_VALUE_ARRAY = new String[]{"用户名"};
}
