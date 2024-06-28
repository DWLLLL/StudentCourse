package com.rabbiter.cm.controller.teacher;

import com.rabbiter.cm.service.teacher.GradeService;
import com.rabbiter.cm.config.themis.annotation.Teacher;
import com.rabbiter.cm.model.vo.TeacherGradeVO;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Teacher
@RequestMapping("/teacher/grade")
@RestController
public class GradeController {
    private final GradeService service;

    public GradeController(GradeService service) {
        this.service = service;
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String courseName, String studentName) {
        return service.getPageCount(courseName, studentName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String courseName, String studentName) {
        return service.getPage(index, courseName, studentName);
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated TeacherGradeVO vo) {
        return service.update(vo);
    }
}
