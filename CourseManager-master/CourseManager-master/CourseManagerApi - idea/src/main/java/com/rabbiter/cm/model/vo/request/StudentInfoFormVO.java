package com.rabbiter.cm.model.vo.request;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.util.Date;

public class StudentInfoFormVO {
    private String password;

    @Email(message = "邮箱格式不正确")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Range(min = 0, max = 1)
    private Integer sex;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "StudentInfoFormVO{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                '}';
    }
}
