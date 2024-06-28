package com.rabbiter.cm.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@TableName("rc_student")
public class StudentEntity {
    public static final String ID = "student_id";
    public static final String CLASS_ID = "student_class_id";
    public static final String NUMBER = "student_number";
    public static final String NAME = "student_name";
    public static final String PASSWORD = "student_password";
    public static final String EMAIL = "student_email";
    public static final String BIRTHDAY = "student_birthday";
    public static final String SEX = "student_sex";
    public static final String LAST_LOGIN_TIME = "student_last_login_time";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择所属班级")
    @TableField(CLASS_ID)
    private Integer classId;

    @Length(min = 12, max = 12, message = "学号长度必须为12位")
    @TableField(NUMBER)
    private String number;

    @NotBlank(message = "学生姓名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @TableField(PASSWORD)
    private String password;

    @Email(message = "邮箱格式不正确")
    @TableField(value = EMAIL, updateStrategy = FieldStrategy.IGNORED)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = BIRTHDAY, updateStrategy = FieldStrategy.IGNORED)
    private Date birthday;

    @Range(min = 0, max = 1)
    @TableField(SEX)
    private Integer sex;

    @TableField(LAST_LOGIN_TIME)
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", classId=" + classId +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
