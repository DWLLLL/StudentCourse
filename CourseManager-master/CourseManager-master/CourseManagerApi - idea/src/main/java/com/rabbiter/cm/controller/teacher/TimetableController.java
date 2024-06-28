package com.rabbiter.cm.controller.teacher;

import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.model.vo.response.ResultVO;
import com.rabbiter.cm.service.teacher.TimetableService;
import com.rabbiter.cm.config.themis.annotation.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/timetable")
@RestController
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
