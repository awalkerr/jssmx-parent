package com.jssmx.sso.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jssmx.sso.pojo.Base;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;

@Table(name = "sys_user")
public class User extends Base {
    @Length(min=6,max = 20,message = "用户名的长度必须在6~20之间")
    private String username;
    @JsonIgnore//json序列化时忽略该字段
    @Length(min=6,max = 20,message = "密码的长度必须在6~20之间")
    private String password;
    private String name;
    private String number;
    @Email(message = "邮箱格式不符合规则！")
    private String email;
    @Length(min=11,max = 11,message = "手机号的长度必须是11位")
    private String phone;
    private String rights;
    private String lastLogin;
    private String ip;
    private String status;
    private String skin;
    private String roleId;
    private String remark;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", rights='" + rights + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", ip='" + ip + '\'' +
                ", status=" + status +
                ", skin='" + skin + '\'' +
                ", roleId=" + roleId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
