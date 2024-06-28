package com.rabbiter.cm.manager.admin;

import com.rabbiter.cm.manager.BaseManager;
import com.rabbiter.cm.dao.ClassDAO;
import com.rabbiter.cm.dao.MajorDAO;
import com.rabbiter.cm.dao.StudentDAO;
import com.rabbiter.cm.model.entity.ClassEntity;
import com.rabbiter.cm.model.entity.MajorEntity;
import com.rabbiter.cm.model.vo.response.IdNameVO;
import com.rabbiter.cm.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassManager extends BaseManager {
    private final MajorDAO majorDAO;
    private final ClassDAO classDAO;
    private final StudentDAO studentDAO;

    public ClassManager(MajorDAO majorDAO, ClassDAO classDAO, StudentDAO studentDAO) {
        this.majorDAO = majorDAO;
        this.classDAO = classDAO;
        this.studentDAO = studentDAO;
    }

    public Integer getPageCount(String departmentName, String majorName, String name) {
        int count = classDAO.count(departmentName, majorName, name);
        return calcPageCount(count, ClassDAO.PAGE_SIZE);
    }

    public List<MajorItemVO> getPage(Integer index, String departmentName, String majorName, String name) {
        return classDAO.getPage(index, departmentName, majorName, name);
    }

    public ClassEntity get(Integer id) {
        return classDAO.get(id);
    }

    public int create(ClassEntity entity) {
        return classDAO.insert(entity);
    }

    public int update(ClassEntity entity) {
        return classDAO.update(entity);
    }

    public int delete(Integer id) {
        return classDAO.delete(id);
    }

    public MajorEntity getMajorById(Integer majorId) {
        return majorDAO.get(majorId);
    }

    public boolean hasStudent(Integer classId) {
        return studentDAO.countByClassId(classId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<ClassEntity> entityList = classDAO.listName();
        for (ClassEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
