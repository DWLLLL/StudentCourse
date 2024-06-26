package com.rabbiter.cm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rabbiter.cm.model.entity.ClassEntity;
import com.rabbiter.cm.model.vo.response.table.MajorItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper extends BaseMapper<ClassEntity> {
    Integer count(@Param("departmentName") String departmentName,@Param("majorName") String majorName, @Param("name")String name);

    IPage<MajorItemVO> getPage(IPage<MajorItemVO> page, @Param("departmentName")String departmentName,@Param("majorName") String majorName, @Param("name")String name);
}
