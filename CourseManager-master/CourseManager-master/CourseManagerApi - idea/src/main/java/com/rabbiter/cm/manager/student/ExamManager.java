package com.rabbiter.cm.manager.student;

import com.rabbiter.cm.manager.BaseManager;
import com.rabbiter.cm.dao.StudentCourseDAO;
import com.rabbiter.cm.model.vo.response.table.StudentExamItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager extends BaseManager {
    private final StudentCourseDAO studentCourseDAO;

    public ExamManager(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return studentCourseDAO.listStudentExam(studentId);
    }
}
