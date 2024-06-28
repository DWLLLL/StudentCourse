package com.rabbiter.cm.model.bo;

import com.rabbiter.cm.model.constant.UserType;
import com.rabbiter.cm.model.entity.AdminEntity;
import com.rabbiter.cm.model.entity.StudentEntity;
import com.rabbiter.cm.model.entity.TeacherEntity;

public class AuthInfoBO {
    private Integer id;
    private String username;
    private String password;
    private Integer userType;
    private Integer permission = 0;

    public AuthInfoBO() {
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType) {
        this(id, username, password, userType, 0);
    }

    private AuthInfoBO(Integer id, String username, String password, Integer userType, Integer permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "AuthInfoBO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", permission=" + permission +
                '}';
    }

    public static AuthInfoBO fromStudent(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.STUDENT);
    }

    public static AuthInfoBO fromTeacher(TeacherEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getNumber(), entity.getPassword(), UserType.TEACHER);
    }

    public static AuthInfoBO fromAdmin(AdminEntity entity) {
        if (entity == null) {
            return null;
        }
        return new AuthInfoBO(entity.getId(), entity.getUsername(), entity.getPassword(), UserType.ADMIN,
                entity.getPrivilege());
    }
}
