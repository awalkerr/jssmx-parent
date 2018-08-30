package com.jssmx.manage.pojo.system;

import com.jssmx.manage.pojo.basic.Base;

import javax.persistence.Table;

@Table(name = "sys_role")
public class Role extends Base {
    private String name;
    private String rights;
    private String parentId;
    private String addQx;
    private String delQx;
    private String editQx;
    private String getQx;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAddQx() {
        return addQx;
    }

    public void setAddQx(String addQx) {
        this.addQx = addQx;
    }

    public String getDelQx() {
        return delQx;
    }

    public void setDelQx(String delQx) {
        this.delQx = delQx;
    }

    public String getEditQx() {
        return editQx;
    }

    public void setEditQx(String editQx) {
        this.editQx = editQx;
    }

    public String getGetQx() {
        return getQx;
    }

    public void setGetQx(String getQx) {
        this.getQx = getQx;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +  '\'' +
                "name='" + name + '\'' +
                ", rights='" + rights + '\'' +
                ", parentId='" + parentId + '\'' +
                ", addQx='" + addQx + '\'' +
                ", delQx='" + delQx + '\'' +
                ", editQx='" + editQx + '\'' +
                ", getQx='" + getQx + '\'' +
                '}';
    }
}
