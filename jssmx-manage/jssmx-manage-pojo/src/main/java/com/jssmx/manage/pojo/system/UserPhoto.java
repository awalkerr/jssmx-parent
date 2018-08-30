package com.jssmx.manage.pojo.system;

import com.jssmx.manage.pojo.basic.Base;

import javax.persistence.Table;

@Table(name = "sys_userphoto")
public class UserPhoto extends Base {
    private String username;
    private String photo0;
    private String photo1;
    private String photo2;
    private String photo3;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto0() {
        return photo0;
    }

    public void setPhoto0(String photo0) {
        this.photo0 = photo0;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }
}
