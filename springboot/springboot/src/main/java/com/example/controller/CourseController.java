package com.example.controller;

import com.example.common.Result;
import com.example.entity.Course;
import com.example.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController //标识这是一个控制器类，Spring会自动注册它并将其识别为REST风格Controller
@RequestMapping("/course") // 标识请求路径
public class CourseController {

    @Resource // 注入依赖，将CourseService类型实例注入到courseService中，使控制器能够调用服务层
    private CourseService courseService;

    // 添加课程
    @PostMapping("/add")
    public Result add(@RequestBody Course course) {
        courseService.add(course);
        return Result.success();
    }

    // 删除课程
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        courseService.deleteById(id);
        return Result.success();
    }

    // 更新课程
    @PutMapping("/update")
    public Result update(@RequestBody Course course) {
        courseService.updateById(course);
        return Result.success();
    }

    // 查询所有课程
    @GetMapping("/selectPage")
    public Result selectPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "2") Integer pageSize,
            Course course) {
        PageInfo<Course> pageInfo = courseService.selectPage(pageNum, pageSize, course);
        return Result.success(pageInfo);
    }//分页查询，并将查询结果封装到 PageInfo<Course> 中

}
