package com.rabbiter.cm.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@TableName("rc_teacher")
public class TeacherEntity {
    public static final String ID = "teacher_id";
    public static final String DEPARTMENT_ID = "teacher_department_id";
    public static final String NUMBER = "teacher_number";
    public static final String NAME = "teacher_name";
    public static final String PASSWORD = "teacher_password";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择所属系")
    @TableField(DEPARTMENT_ID)
    private Integer departmentId;

    @Length(min = 12, max = 12, message = "工号长度必须为12位")
    @TableField(NUMBER)
    private String number;

    @NotBlank(message = "教师姓名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @TableField(PASSWORD)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
