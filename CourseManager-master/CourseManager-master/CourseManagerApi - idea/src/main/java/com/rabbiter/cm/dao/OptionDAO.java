package com.rabbiter.cm.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbiter.cm.dao.mapper.OptionMapper;
import com.rabbiter.cm.model.entity.OptionEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class OptionDAO extends BaseDAO{
    @Resource
    private OptionMapper optionMapper;

    public Boolean getAllowStudentSelect() {
        List<OptionEntity> optionEntities = optionMapper.selectList(new QueryWrapper<OptionEntity>().eq("option_key", "ALLOW_STUDENT_SELECT"));
        String allowStudentSelect = optionEntities.get(0).getOptionValue();

        try {
            return Boolean.parseBoolean(allowStudentSelect);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean getAllowTeacherGrade() {
        List<OptionEntity> optionEntities = optionMapper.selectList(new QueryWrapper<OptionEntity>().eq("option_key", "ALLOW_TEACHER_GRADE"));
        String allowTeacherGrade = optionEntities.get(0).getOptionValue();

        try {
            return Boolean.parseBoolean(allowTeacherGrade);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setAllowStudentSelect(Boolean status) {
        List<OptionEntity> optionEntities = optionMapper.selectList(new QueryWrapper<OptionEntity>().eq("option_key", "ALLOW_STUDENT_SELECT"));
        if(CollectionUtils.isEmpty(optionEntities)) {
            OptionEntity optionEntity = new OptionEntity();
            optionEntity.setOptionKey("ALLOW_STUDENT_SELECT");
            optionEntity.setOptionValue("true");
            optionMapper.insert(optionEntity);
            return;
        }
        for (OptionEntity optionEntity : optionEntities) {
            optionEntity.setOptionValue(status + "");
            optionMapper.updateById(optionEntity);
        }
    }

    public void setAllowTeacherGrade(Boolean status) {
        List<OptionEntity> optionEntities = optionMapper.selectList(new QueryWrapper<OptionEntity>().eq("option_key", "ALLOW_TEACHER_GRADE"));
        if(CollectionUtils.isEmpty(optionEntities)) {
            OptionEntity optionEntity = new OptionEntity();
            optionEntity.setOptionKey("ALLOW_TEACHER_GRADE");
            optionEntity.setOptionValue("true");
            optionMapper.insert(optionEntity);
            return;
        }
        for (OptionEntity optionEntity : optionEntities) {
            optionEntity.setOptionValue(status + "");
            optionMapper.updateById(optionEntity);
        }
    }
}
