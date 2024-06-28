package com.rabbiter.cm.controller;

import com.rabbiter.cm.config.themis.annotation.Admin;
import com.rabbiter.cm.service.OptionService;
import com.rabbiter.cm.model.vo.request.BoolOptionVO;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/option")
@RestController
public class OptionController extends BaseController {
    private final OptionService service;

    public OptionController(OptionService service) {
        this.service = service;
    }

    @GetMapping("/allowStudentSelect")
    public ResultVO getAllowStudentSelect() {
        return service.getAllowStudentSelect();
    }

    @Admin(Admin.STUDENT_COURSE_MANAGE)
    @PutMapping("/allowStudentSelect")
    public ResultVO setAllowStudentSelect(@RequestBody @Validated BoolOptionVO option) {
        return service.setAllowStudentSelect(option.getOption());
    }

    @GetMapping("/allowTeacherGrade")
    public ResultVO getAllowTeacherGrade() {
        return service.getAllowTeacherGrade();
    }

    @Admin(Admin.STUDENT_COURSE_MANAGE)
    @PutMapping("/allowTeacherGrade")
    public ResultVO setAllowTeacherGrade(@RequestBody @Validated BoolOptionVO option) {
        return service.setAllowTeacherGrade(option.getOption());
    }
}
