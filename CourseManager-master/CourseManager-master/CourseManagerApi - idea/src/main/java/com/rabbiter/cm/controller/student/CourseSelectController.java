package com.rabbiter.cm.controller.student;

import com.rabbiter.cm.config.themis.annotation.Student;
import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.service.student.CourseSelectService;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Student
@RequestMapping("/student/course/select")
@RestController
public class CourseSelectController extends BaseController {
    private final CourseSelectService service;

    public CourseSelectController(CourseSelectService service) {
        this.service = service;
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String courseName, String teacherName) {
        return service.getPageCount(courseName, teacherName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String courseName, String teacherName) {
        return service.getPage(index, courseName, teacherName);
    }

    @PostMapping("/{id}")
    public ResultVO create(@PathVariable Integer id) {
        return service.create(id);
    }
}
