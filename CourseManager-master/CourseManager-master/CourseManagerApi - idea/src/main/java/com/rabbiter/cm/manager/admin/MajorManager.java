package com.rabbiter.cm.manager.admin;

import com.rabbiter.cm.manager.BaseManager;
import com.rabbiter.cm.dao.ClassDAO;
import com.rabbiter.cm.dao.DepartmentDAO;
import com.rabbiter.cm.dao.MajorDAO;
import com.rabbiter.cm.model.entity.DepartmentEntity;
import com.rabbiter.cm.model.entity.MajorEntity;
import com.rabbiter.cm.model.vo.response.IdNameVO;
import com.rabbiter.cm.model.vo.response.table.MajorItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MajorManager extends BaseManager {
    private final MajorDAO majorDAO;
    private final DepartmentDAO departmentDAO;
    private final ClassDAO classDAO;

    public MajorManager(MajorDAO majorDAO, DepartmentDAO departmentDAO, ClassDAO classDAO) {
        this.majorDAO = majorDAO;
        this.departmentDAO = departmentDAO;
        this.classDAO = classDAO;
    }

    public Integer getPageCount(String departmentName, String name) {
        int count = majorDAO.count(departmentName, name);
        return calcPageCount(count, MajorDAO.PAGE_SIZE);
    }

    public List<MajorItemVO> getPage(Integer index, String departmentName, String name) {
        return majorDAO.getPage(index, departmentName, name);
    }

    public MajorEntity get(Integer id) {
        return majorDAO.get(id);
    }

    public int create(MajorEntity entity) {
        return majorDAO.insert(entity);
    }

    public int update(MajorEntity entity) {
        return majorDAO.update(entity);
    }

    public int delete(Integer id) {
        return majorDAO.delete(id);
    }

    public boolean hasClass(Integer majorId) {
        return classDAO.countByMajorId(majorId) > 0;
    }

    public DepartmentEntity getDepartmentById(Integer id) {
        return departmentDAO.get(id);
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<MajorEntity> entityList = majorDAO.listName();
        for (MajorEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
