package com.jssmx.manage.pojo.system;

import com.jssmx.manage.pojo.basic.Base;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "sys_menu")
public class Menu extends Base {
    private String name;    //菜单名称
    private String url;     //链接
    private String parentId;//上级菜单ID
    private String orderId;   //排序
    private String icon;    //图标
    private String type;    //类型
    private String state;   //菜单状态
    @Transient
    private String target;
    @Transient
    private Menu parentMenu;
    @Transient
    private List<Menu> subMenu;
    @Transient
    private boolean hasMenu = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    public boolean isHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(boolean hasMenu) {
        this.hasMenu = hasMenu;
    }
}
