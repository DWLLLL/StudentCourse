package com.rabbiter.cm.manager.teacher;

import com.rabbiter.cm.manager.BaseManager;
import com.rabbiter.cm.dao.TeacherDAO;
import com.rabbiter.cm.model.vo.response.table.TeacherCourseItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher_CourseManager")
public class CourseManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public CourseManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<TeacherCourseItemVO> listTeacherCourse(Integer teacherId) {
        return teacherDAO.listTeacherCourse(teacherId);
    }
}
