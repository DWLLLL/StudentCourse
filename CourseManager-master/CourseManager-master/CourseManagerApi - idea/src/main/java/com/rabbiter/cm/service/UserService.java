package com.rabbiter.cm.service;

import com.rabbiter.cm.manager.LoginStatusManager;
import com.rabbiter.cm.manager.UserManager;
import com.rabbiter.cm.model.bo.AuthInfoBO;
import com.rabbiter.cm.model.bo.LoginStatusBO;
import com.rabbiter.cm.model.constant.UserType;
import com.rabbiter.cm.model.vo.response.ResultVO;
import com.rabbiter.cm.util.Md5Encrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends BaseService {
    private static final String PASSWORD_SALT = "_Rain_Ng-_Azure_99";

    private final HttpSession session;
    private final UserManager manager;
    private final LoginStatusManager loginStatusManager;
    private final Md5Encrypt md5Encrypt;

    public UserService(HttpSession session, UserManager manager, LoginStatusManager loginStatusManager, Md5Encrypt md5Encrypt) {
        this.session = session;
        this.manager = manager;
        this.loginStatusManager = loginStatusManager;
        this.md5Encrypt = md5Encrypt;
    }

    public ResultVO login(String username, String password, Integer userType) {
        AuthInfoBO authInfo = manager.getAuthInfoByUsername(username, userType);
        if (authInfo == null) {
            return failedResult("用户不存在");
        }
//        String passwordHash = computePasswordHash(password);
        if (!password.equals(authInfo.getPassword())) {
            return failedResult("密码错误");
        }

        if (authInfo.getUserType().equals(UserType.STUDENT)) {
            manager.updateStudentLastLoginTime(username);
        }

        LoginStatusBO statusBO = LoginStatusBO.fromAuthInfo(authInfo);
        loginStatusManager.setLoginStatus(session, statusBO);

        return result(statusBO);
    }

    public ResultVO getLoginStatus() {
        LoginStatusBO statusBO = loginStatusManager.getLoginStatus(session);
        return result(statusBO);
    }

    public ResultVO logout() {
        loginStatusManager.setLoginStatus(session, null);
        return result("注销成功");
    }

    public String computePasswordHash(String password) {
        String md5 = md5Encrypt.computeHexString(password);
        return md5Encrypt.computeHexString(md5 + PASSWORD_SALT);
    }
}
