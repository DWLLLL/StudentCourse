package com.rabbiter.cm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rabbiter.cm.model.entity.TeacherEntity;
import com.rabbiter.cm.model.vo.response.table.TeacherCourseItemVO;
import com.rabbiter.cm.model.vo.response.table.TeacherItemVO;
import com.rabbiter.cm.model.vo.response.table.TimetableItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper extends BaseMapper<TeacherEntity> {
    Integer count(@Param("departmentName")String departmentName, @Param("name")String name);

    IPage<TeacherItemVO> getPage(IPage<TeacherItemVO> page, @Param("departmentName")String departmentName,@Param("name") String name);

    List<TimetableItemVO> listTeacherTimetable(Integer teacherId);

    List<TeacherCourseItemVO> listTeacherCourse(Integer teacherId);
}
