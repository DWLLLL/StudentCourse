package com.rabbiter.cm.service.student;

import com.rabbiter.cm.manager.student.ExamManager;
import com.rabbiter.cm.service.BaseService;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends BaseService {
    private final ExamManager manager;

    public ExamService(ExamManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        return result(manager.listStudentExam(getUserId()));
    }
}
