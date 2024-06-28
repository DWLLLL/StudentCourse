package com.rabbiter.cm.config.themis;

import com.rabbiter.cm.model.constant.UserType;

public class Permission {
    private Integer userType = UserType.NO;
    private Integer permission = 0;
    private Boolean needLogin = true;

    public Permission() {

    }

    public Permission(Integer userType) {
        this.userType = userType;
    }

    public Permission(Integer userType, Integer permission) {
        this.userType = userType;
        this.permission = permission;
    }

    public Permission(Boolean needLogin) {
        this.needLogin = needLogin;
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

    public Boolean getNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(Boolean needLogin) {
        this.needLogin = needLogin;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "userType=" + userType +
                ", permission=" + permission +
                ", needLogin=" + needLogin +
                '}';
    }
}
