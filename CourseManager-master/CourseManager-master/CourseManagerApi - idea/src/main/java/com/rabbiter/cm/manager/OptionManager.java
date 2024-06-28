package com.rabbiter.cm.manager;

import com.rabbiter.cm.dao.OptionDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OptionManager extends BaseManager {

    @Resource
    private OptionDAO optionDAO;


    public Boolean getAllowStudentSelect() {
        return optionDAO.getAllowStudentSelect();
    }

    public void setAllowStudentSelect(Boolean status) {
        optionDAO.setAllowStudentSelect(status);
    }

    public Boolean getAllowTeacherGrade() {
        return optionDAO.getAllowTeacherGrade();
    }

    public void setAllowTeacherGrade(Boolean status) {
        optionDAO.setAllowTeacherGrade(status);
    }
}
