package com.jssmx.manage.pojo.system;

import com.jssmx.manage.pojo.basic.Base;

import javax.persistence.Table;

@Table(name = "sys_button")
public class Button extends Base {
    private String name;
    private String qxName;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQxName() {
        return qxName;
    }

    public void setQxName(String qxName) {
        this.qxName = qxName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
