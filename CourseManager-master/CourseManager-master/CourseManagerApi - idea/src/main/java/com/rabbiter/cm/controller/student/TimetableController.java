package com.rabbiter.cm.controller.student;

import com.rabbiter.cm.config.themis.annotation.Student;
import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.service.student.TimetableService;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Student
@RequestMapping("/student/timetable")
@RestController("student_timeTableController")
public class TimetableController extends BaseController {
    private final TimetableService service;

    public TimetableController(TimetableService service) {
        this.service = service;
    }

    @RequestMapping
    public ResultVO get() {
        return service.get();
    }
}
