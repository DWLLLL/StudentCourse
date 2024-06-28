package com.rabbiter.cm.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StudentItemVO {
    private Integer id;
    private String number;
    private String name;
    private String className;
    private String majorName;
    private Integer sex;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "StudentItemVO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", majorName='" + majorName + '\'' +
                ", sex=" + sex +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
