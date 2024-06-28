package com.rabbiter.cm.controller.student;

import com.rabbiter.cm.config.themis.annotation.Student;
import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.service.student.InfoService;
import com.rabbiter.cm.model.vo.request.StudentInfoFormVO;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Student
@RequestMapping("/student/info")
@RestController
public class InfoController extends BaseController {
    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO formVO) {
        return service.update(formVO);
    }
}
