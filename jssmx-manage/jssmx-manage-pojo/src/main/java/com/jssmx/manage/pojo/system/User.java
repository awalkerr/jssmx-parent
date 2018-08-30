package com.jssmx.manage.pojo.system;

import com.jssmx.manage.pojo.basic.Base;
import com.jssmx.manage.pojo.basic.Page;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "sys_user")
public class User extends Base {
    private String username;
    private String password;
    private String email;
    private String name;
    private String rights;
    private String roleId;
    private String lastLogin;
    private String ip;
    private String state;
    private String skin;
    @Transient
    private Role role;
    @Transient
    private Page page;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Page getPage() {
        if(page == null){
            page = new Page();
        }
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", rights='" + rights + '\'' +
                ", roleId='" + roleId + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", ip='" + ip + '\'' +
                ", state='" + state + '\'' +
                ", skin='" + skin + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
