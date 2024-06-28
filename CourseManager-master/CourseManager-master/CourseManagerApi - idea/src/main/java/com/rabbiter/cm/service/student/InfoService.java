package com.rabbiter.cm.service.student;

import com.rabbiter.cm.manager.student.InfoManager;
import com.rabbiter.cm.service.BaseService;
import com.rabbiter.cm.service.UserService;
import com.rabbiter.cm.model.entity.StudentEntity;
import com.rabbiter.cm.model.vo.request.StudentInfoFormVO;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InfoService extends BaseService {
    private final UserService userService;

    private final InfoManager manager;

    public InfoService(UserService userService, InfoManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    public ResultVO get() {
        return result(manager.getStudentInfoByStudentId(getUserId()));
    }

    public ResultVO update(@RequestBody @Validated StudentInfoFormVO studentInfoForm) {
        StudentEntity student = manager.getStudentById(getUserId());

        String password = studentInfoForm.getPassword();
        if (password == null || password.equals("")) {
            password = student.getPassword();
        } else {
            password = userService.computePasswordHash(password);
        }

        BeanUtils.copyProperties(studentInfoForm, student);
        student.setPassword(password);
        manager.updateStudent(student);

        return result("更新成功");
    }
}
