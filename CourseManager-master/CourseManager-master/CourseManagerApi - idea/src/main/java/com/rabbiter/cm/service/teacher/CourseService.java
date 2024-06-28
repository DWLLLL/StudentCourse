package com.rabbiter.cm.service.teacher;

import com.rabbiter.cm.manager.teacher.CourseManager;
import com.rabbiter.cm.service.BaseService;
import com.rabbiter.cm.model.vo.response.ResultVO;
import com.rabbiter.cm.model.vo.response.table.TeacherCourseItemVO;
import com.rabbiter.cm.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public CourseService(CourseManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer teacherId = getUserId();

        List<TeacherCourseItemVO> list = manager.listTeacherCourse(teacherId);
        for (TeacherCourseItemVO vo : list) {
            vo.setTime(lessonTimeConverter.covertTimePart(vo.getTime()));
        }

        return result(list);
    }
}
