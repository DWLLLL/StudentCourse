package com.rabbiter.cm.service.teacher;

import com.rabbiter.cm.manager.teacher.TimetableManager;
import com.rabbiter.cm.service.BaseService;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.stereotype.Service;

@Service
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer teacherId = getUserId();
        return result(manager.listTeacherTimetable(teacherId));
    }
}
