package com.jssmx.manage.web.utility;

import com.jssmx.manage.pojo.system.Menu;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import java.util.List;
import java.util.Map;

/**
 * 权限处理
 */
public class Jurisdiction {

    /**
     * 访问权限及初始化按钮权限(控制按钮的显示 增删改查)
     * @param menuUrl  菜单路径
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean menuJurisdiction(String menuUrl){
        String username = getUsername();
        Session session = getSession();
        List<Menu> menuList = (List<Menu>) session.getAttribute(username + Const.SESSION_ALL_MENULIST);
        return readMenu(menuList,menuUrl,session,username);
    }

    /**
     * 校验菜单权限并初始按钮权限用于页面按钮显示与否(递归处理)
     * @param menuList:传入的总菜单(设置菜单时，.do前面的不要重复)
     * @param menuUrl:访问地址
     * @return
     */
    @SuppressWarnings("unchecked")
    private static boolean readMenu(List<Menu> menuList,String menuUrl,Session session,String username){
        for (Menu menu:menuList){
            if(menu.getUrl().split(".do")[0].equals(menuUrl.split(".do")[0])){
                if(!menu.isHasMenu()){
                    return false;
                }else{
                    Map<String, String> map = (Map<String, String>)session.getAttribute(username + Const.SESSION_QX);//按钮权限(增删改查)
                    map.remove("add");
                    map.remove("del");
                    map.remove("edit");
                    map.remove("get");

                    String menuId = menu.getId();
                    boolean isAdmin = "administrator".equals(username);
                    map.put("add",(RightsHelper.testRights(map.get("adds"),menuId)) || isAdmin ? "1" : "0");
                    map.put("del",(RightsHelper.testRights(map.get("dels"),menuId)) || isAdmin ? "1" : "0");
                    map.put("edit",(RightsHelper.testRights(map.get("edits"),menuId)) || isAdmin ? "1" : "0");
                    map.put("get",(RightsHelper.testRights(map.get("gets"),menuId)) || isAdmin ? "1" : "0");

                    session.removeAttribute(username + Const.SESSION_QX);
                    session.setAttribute(username + Const.SESSION_QX,map);
                    return true;
                }
            }else {
                if(!readMenu(menu.getSubMenu(),menuUrl,session,username)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 按钮权限(方法中校验)
     * @param menuUrl  菜单路径
     * @param type  类型(add、del、edit、get)
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean buttonJurisdiction(String menuUrl,String type){
        String username = getUsername();
        Session session = getSession();
        List<Menu> menuList = (List<Menu>) session.getAttribute(username + Const.SESSION_ALL_MENULIST);
        return readButton(menuList,menuUrl,session,username,type);
    }

    /**
     * 校验按钮权限(递归处理)
     * @param menuList:传入的总菜单(设置菜单时，.do前面的不要重复)
     * @param menuUrl:访问地址
     * @return
     */
    @SuppressWarnings("unchecked")
    private static boolean readButton(List<Menu> menuList,String menuUrl,Session session,String username, String type){
        for (Menu menu:menuList){
            if(menu.getUrl().split(".do")[0].equals(menuUrl.split(".do")[0])){
                if(!menu.isHasMenu()){
                    return false;
                }else{
                    Map<String, String> map = (Map<String, String>)session.getAttribute(username + Const.SESSION_QX);//按钮权限(增删改查)

                    String menuId = menu.getId();
                    boolean isAdmin = "administrator".equals(username);

                    if("add".equals(type)) {
                        return RightsHelper.testRights(map.get("adds"), menuId) || isAdmin;
                    }else if("del".equals(type)){
                        return RightsHelper.testRights(map.get("dels"),menuId) || isAdmin;
                    }else if("edit".equals(type)) {
                        return RightsHelper.testRights(map.get("edits"), menuId) || isAdmin;
                    }else if("get".equals(type)) {
                        return RightsHelper.testRights(map.get("gets"), menuId) || isAdmin;
                    }
                }
            }else {
                if(!readButton(menu.getSubMenu(),menuUrl,session,username,type)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 获取当前登录的用户名
     * @return
     */
    public static String getUsername(){
        return getSession().getAttribute(Const.SESSION_USERNAME).toString();
    }

    /**
     * 获取用户的最高组织机构权限集合
     * @return
     */
    public static String getDepartmentIds(){
        return getSession().getAttribute(Const.DEPARTMENT_IDS).toString();
    }

    /**
     * 获取用户的最高组织机构权限
     * @return
     */
    public static String getDepartmentId(){
        return getSession().getAttribute(Const.DEPARTMENT_ID).toString();
    }

    /**
     * 获取当前按钮权限(增删改查)
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String,String> getBtnJur(){
        return (Map<String,String>)getSession().getAttribute(getUsername()+Const.SESSION_QX);
    }

    /**
     * shiro管理session
     * @return
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }
}
