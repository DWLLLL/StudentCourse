package com.rabbiter.cm.manager.student;

import com.rabbiter.cm.manager.BaseManager;
import com.rabbiter.cm.dao.StudentCourseDAO;
import com.rabbiter.cm.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("student_timetableManager")
public class TimetableManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;

    public TimetableManager(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    public List<TimetableItemVO> listStudentTimetable(Integer studentId) {
        return studentCourseDAO.listStudentTimetable(studentId);
    }
}
