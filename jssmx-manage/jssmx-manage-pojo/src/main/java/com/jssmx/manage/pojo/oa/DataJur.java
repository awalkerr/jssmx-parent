package com.jssmx.manage.pojo.oa;

import com.jssmx.manage.pojo.basic.Base;

import javax.persistence.Table;

@Table(name = "oa_datajur")
public class DataJur extends Base {
    private String departmentIds;
    private String staffId;
    private String departmentId;

    public String getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String departmentIds) {
        this.departmentIds = departmentIds;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
