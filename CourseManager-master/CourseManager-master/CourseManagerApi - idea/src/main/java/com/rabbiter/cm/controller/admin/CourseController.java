package com.rabbiter.cm.controller.admin;

import com.rabbiter.cm.config.themis.annotation.Admin;
import com.rabbiter.cm.controller.BaseController;
import com.rabbiter.cm.service.admin.CourseService;
import com.rabbiter.cm.model.entity.CourseEntity;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin(Admin.COURSE_MANAGE)
@RequestMapping("/admin/course")
@RestController
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated CourseEntity entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public ResultVO delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated CourseEntity entity) {
        return service.update(entity);
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(String departmentName, String teacherName, String name) {
        return service.getPageCount(departmentName, teacherName, name);
    }

    @RequestMapping("/page")
    public ResultVO getPage(String departmentName, String teacherName, String name) {
        return service.getPage(1, departmentName, teacherName, name);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String departmentName, String teacherName, String name) {
        return service.getPage(index, departmentName, teacherName, name);
    }

    @Admin
    @RequestMapping("/names")
    public ResultVO listName() {
        return service.listName();
    }
}
