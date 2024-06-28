package com.rabbiter.cm.controller.teacher;

import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.model.vo.response.ResultVO;
import com.rabbiter.cm.service.teacher.CourseService;
import com.rabbiter.cm.config.themis.annotation.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/course")
@RestController("teacher_courseController")
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
