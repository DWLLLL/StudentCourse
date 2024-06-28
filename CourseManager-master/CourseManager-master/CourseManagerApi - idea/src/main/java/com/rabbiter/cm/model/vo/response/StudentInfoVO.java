package com.rabbiter.cm.model.vo.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StudentInfoVO {
    private String number;
    private String name;
    private String departmentName;
    private String majorName;
    private String className;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StudentInfoVO{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", className='" + className + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }
}
