package com.rabbiter.cm.controller.student;

import com.rabbiter.cm.config.themis.annotation.Student;
import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.model.vo.response.ResultVO;
import com.rabbiter.cm.service.student.ExamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/exam")
@RestController
public class ExamController extends BaseController {
    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
