package com.rabbiter.cm.manager.teacher;

import com.rabbiter.cm.manager.BaseManager;
import com.rabbiter.cm.dao.TeacherDAO;
import com.rabbiter.cm.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public TimetableManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TimetableItemVO> listTeacherTimetable(Integer teacherId) {
        return teacherDAO.listTeacherTimetable(teacherId);
    }
}
