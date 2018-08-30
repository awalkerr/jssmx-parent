package com.jssmx.manage.web.controller.system;

import com.jssmx.common.utility.PageData;
import com.jssmx.manage.pojo.oa.DataJur;
import com.jssmx.manage.pojo.system.Button;
import com.jssmx.manage.pojo.system.Menu;
import com.jssmx.manage.pojo.system.Role;
import com.jssmx.manage.pojo.system.User;
import com.jssmx.manage.service.base.PropertiesService;
import com.jssmx.manage.service.oa.DataJurService;
import com.jssmx.manage.service.system.ButtonService;
import com.jssmx.manage.service.system.MenuService;
import com.jssmx.manage.service.system.RoleService;
import com.jssmx.manage.service.system.UserService;
import com.jssmx.manage.web.controller.base.BaseController;
import com.jssmx.manage.web.utility.Const;
import com.jssmx.manage.web.utility.Jurisdiction;
import com.jssmx.manage.web.utility.RightsHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private DataJurService dataJurService;
    @Resource
    private MenuService menuService;
    @Resource
    private RoleService roleService;
    @Resource
    private ButtonService buttonService;
    @Resource
    private PropertiesService propertiesService;

    /**
     * 到登录页面
     */
    @GetMapping(value = "/login_toLogin")
    public ModelAndView toLogin() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("sysName", propertiesService.SYS_NAME);
        mv.setViewName("system/index/login");
        return mv;
    }

    /**
     * 请求登录，用户验证
     */
    @PostMapping(value = "/login_login", produces = "application/json;charset=UTF-8")
    public PageData login() {
        PageData pageData = new PageData();
        PageData pd = this.getPageData();
        String[] data = pd.getString("data").split(",");

        String key = "result";

        if (data.length != 2) {
            pageData.put(key, "error");
            return pageData;
        }

        // 邮箱或者用户名
        String loginName = data[0];
        if (loginName.length() < 8) {
            pageData.put(key, "bitErr");
            return pageData;
        }

        String password = data[1];
        String passwd = new SimpleHash("SHA-1", loginName, password).toString();    //密码加密

        pd.put("loginName", loginName);
        pd.put("password", passwd);
        User user = userService.getUserByLoginNameAndPwd(pd);

        if (null == user) {
            pageData.put(key, "userErr");     //用户名或者密码错误
            logger.info(loginName + "登录系统密码或用户名错误");
        } else {
            removeSession(pd.getString("username"));
            Session session = Jurisdiction.getSession();

            userService.updateLastLogin(user);
            session.setAttribute(Const.SESSION_USER, user);

            // shiro加入身份验证
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), passwd);
            try {
                subject.login(token);
                pageData.put(key, "success");
            } catch (Exception e) {
                pageData.put(key, "fails");
            }
        }

        return pageData;
    }

    /**
     * 访问系统主页
     */
    @GetMapping(value = "/main/{changeMenu}")
    public ModelAndView login_index(@PathVariable("changeMenu") String changeMenu) {
        ModelAndView mv = new ModelAndView();
        try {
            Session session = Jurisdiction.getSession();
            User user = (User) session.getAttribute(Const.SESSION_USER);
            if (null != user) {
                User userr = (User) session.getAttribute(Const.SESSION_USERROL);
                if (null == userr) {
                    user = userService.getUserAndRoleById(user.getId());
                    session.setAttribute(Const.SESSION_USERROL, user);
                } else {
                    user = userr;
                }

                String username = user.getUsername();
                Role role = user.getRole();
                String roleRights = (null != role) ? role.getRights() : "";
                session.setAttribute(username + Const.SESSION_ROLE_RIGHTS, roleRights);
                session.setAttribute(Const.SESSION_USERNAME, username);

                setAttributeToAllDepartmentId(session, username);//把用户的组织机构权限放到session里面

                List<Menu> menuList = getAttributeMenu(session, username, roleRights);
                menuList = changeMenu(menuList, session, username, changeMenu);// 切换菜单
                if (null == session.getAttribute(username + Const.SESSION_QX)) {
                    session.setAttribute(username + Const.SESSION_QX, getUserQx(username));
                }
                updateRemoteIP(username);
                mv.setViewName("system/index/main");
                mv.addObject("user",user);
                mv.addObject("menuList",menuList);
            } else {
                mv.setViewName("system/index/login");
            }
        } catch (Exception e) {
            mv.setViewName("system/index/login");
            logger.error(e.getMessage(), e);
        }

        mv.addObject("sysName", propertiesService.SYS_NAME);
        mv.setViewName("system/index/main");
        return mv;
    }

    /**
     * 进入tab标签
     */
    @GetMapping(value = "/tab")
    public ModelAndView tab(){
        return new ModelAndView("system/index/tab");
    }

    @GetMapping(value = "/login_default")
    public ModelAndView defaultPage(){
        ModelAndView mv = new ModelAndView();
        PageData pd=new PageData();
        pd.put("userCount",111);
        pd.put("appUserCount",23000);
        mv.addObject("pd",pd);
        mv.setViewName("system/index/default");
        return mv;
    }


    /**
     * 更新用户IP地址
     * @param username
     */
    private void updateRemoteIP(String username){
        HttpServletRequest request = this.getRequest();
        String ip;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = request.getHeader("x-forwarded-for");
        }
        userService.updateRemoteIP(username,ip);
    }

    /**
     * 获取用户权限
     */
    private PageData getUserQx(String username) {
        PageData pd = new PageData();

        Role role = roleService.getRoleByUsername(username);
        pd.put("adds", role.getAddQx());
        pd.put("dels", role.getDelQx());
        pd.put("edits", role.getEditQx());
        pd.put("gets", role.getGetQx());

        List<Button> buttonList;
        if (propertiesService.SYS_ADMIN_NAME.equals(username)) {
            buttonList = buttonService.queryAll();
        } else {
            buttonList = buttonService.listAllQxNameByRoleId(role.getId());
        }
        for (Button b : buttonList) {
            pd.put(b.getQxName(), "1");
        }
        return pd;
    }

    /**
     * 菜单缓存
     */
    @SuppressWarnings("unchecked")
    private List<Menu> getAttributeMenu(Session session, String username, String roleRights) {
        List<Menu> allMenuList;
        if (null == session.getAttribute(username + Const.SESSION_ALL_MENULIST)) {
            allMenuList = menuService.listAllMenuQx("0");
            if (StringUtils.isNotEmpty(roleRights)) {
                allMenuList = readMenu(allMenuList, roleRights);
            }
            session.setAttribute(username + Const.SESSION_ALL_MENULIST, allMenuList);
        } else {
            allMenuList = (List<Menu>) session.getAttribute(username + Const.SESSION_ALL_MENULIST);
        }
        return allMenuList;
    }

    /**
     * 根据角色权限获取本权限的菜单列表(递归处理)
     */
    private List<Menu> readMenu(List<Menu> menuList, String roleRights) {
        for (Menu menu : menuList) {
            menu.setHasMenu(RightsHelper.testRights(roleRights, menu.getId()));
            if (menu.isHasMenu()) {
                readMenu(menu.getSubMenu(), roleRights);
            }
        }
        return menuList;
    }

    /**
     * 切换菜单处理
     */
    @SuppressWarnings("unchecked")
    private List<Menu> changeMenu(List<Menu> allMenuList, Session session, String username, String changeMenu) {
        List<Menu> menuList;
        if (null == session.getAttribute(username + Const.SESSION_MENULIST) || "yes".equals(changeMenu)) {
            List<Menu> menuList1 = new ArrayList<>();
            List<Menu> menuList2 = new ArrayList<>();
            for (Menu menu : allMenuList) {
                if ("1".equals(menu.getType())) {
                    menuList1.add(menu);
                } else {
                    menuList2.add(menu);
                }
            }
            session.removeAttribute(username + Const.SESSION_MENULIST);
            if ("2".equals(session.getAttribute("changeMenu"))) {
                session.setAttribute(username + Const.SESSION_MENULIST, menuList1);
                session.removeAttribute("changeMenu");
                session.setAttribute("changeMenu", "1");
                menuList = menuList1;
            } else {
                session.setAttribute(username + Const.SESSION_MENULIST, menuList2);
                session.removeAttribute("changeMenu");
                session.setAttribute("changeMenu", "2");
                menuList = menuList2;
            }
        } else {
            menuList = (List<Menu>) session.getAttribute(username + Const.SESSION_MENULIST);
        }
        return menuList;
    }

    /**
     * 把用户的组织结构权限放到session中
     */
    private void setAttributeToAllDepartmentId(Session session, String username) {
        String departmentIds = "0", departmentId = "0";
        if (!propertiesService.SYS_ADMIN_NAME.equals(username)) {
            DataJur dataJur = dataJurService.getDataJurByUsername(username);
            departmentIds = (null == dataJur) ? "无权" : dataJur.getDepartmentIds();
            departmentId = (null == dataJur) ? "无权" : dataJur.getDepartmentId();
        }
        session.setAttribute(Const.DEPARTMENT_IDS, departmentIds);//把用户的组织机构权限集合放到session里面
        session.setAttribute(Const.DEPARTMENT_ID, departmentId);//把用户的最高组织机构权限放到session里面
    }

    /**
     * 清理session
     */
    private void removeSession(String username) {
        Session session = Jurisdiction.getSession();
        session.removeAttribute(Const.SESSION_USERNAME);
        session.removeAttribute(username + Const.SESSION_ALL_MENULIST);
        session.removeAttribute(username + Const.SESSION_QX);
        session.removeAttribute(username + Const.SESSION_ROLE_RIGHTS);
        session.removeAttribute(Const.SESSION_USERROL);
        session.removeAttribute(Const.DEPARTMENT_IDS);
        session.removeAttribute(Const.DEPARTMENT_ID);
    }

}
