package com.jssmx.manage.pojo.oa;

import com.jssmx.manage.pojo.basic.Base;

import javax.persistence.Table;

/**
 * 员工表
 */
@Table(name = "oa_staff")
public class Staff extends Base {
    private String name;
    private String eName;               // 英语名字
    private String code;                // 编码
    private String departmentId;
    private String functions;           // 职责
    private String tel;
    private String email;
    private String sex;
    private String birthday;
    private String nation;              // 民族
    private String jobType;             // 岗位类型
    private String jobJoinTime;         // 参加工作时间
    private String oldAddress;          // 籍贯
    private String political;           // 政治面貌
    private String pJoinTime;           // 入团时间
    private String sfId;                // 身份证
    private String marital;             // 婚姻状况
    private String dJoinTime;           // 进本单位时间
    private String post;                // 现岗位
    private String poJoinTime;          // 上岗时间
    private String education;           // 学历
    private String school;              // 毕业学校
    private String major;               // 专业
    private String title;               // 职称
    private String certificate;         // 职业资格证
    private String contractLength;      // 劳动合同时长
    private String cStartTime;          // 签订日期
    private String cEndTime;            // 终止日期
    private String address;             // 现住址
    private String userId;
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobJoinTime() {
        return jobJoinTime;
    }

    public void setJobJoinTime(String jobJoinTime) {
        this.jobJoinTime = jobJoinTime;
    }

    public String getOldAddress() {
        return oldAddress;
    }

    public void setOldAddress(String oldAddress) {
        this.oldAddress = oldAddress;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getpJoinTime() {
        return pJoinTime;
    }

    public void setpJoinTime(String pJoinTime) {
        this.pJoinTime = pJoinTime;
    }

    public String getSfId() {
        return sfId;
    }

    public void setSfId(String sfId) {
        this.sfId = sfId;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getdJoinTime() {
        return dJoinTime;
    }

    public void setdJoinTime(String dJoinTime) {
        this.dJoinTime = dJoinTime;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPoJoinTime() {
        return poJoinTime;
    }

    public void setPoJoinTime(String poJoinTime) {
        this.poJoinTime = poJoinTime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getContractLength() {
        return contractLength;
    }

    public void setContractLength(String contractLength) {
        this.contractLength = contractLength;
    }

    public String getcStartTime() {
        return cStartTime;
    }

    public void setcStartTime(String cStartTime) {
        this.cStartTime = cStartTime;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getcEndTime() {
        return cEndTime;
    }

    public void setcEndTime(String cEndTime) {
        this.cEndTime = cEndTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
