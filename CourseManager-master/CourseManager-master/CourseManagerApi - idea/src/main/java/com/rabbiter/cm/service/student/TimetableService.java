package com.rabbiter.cm.service.student;

import com.rabbiter.cm.manager.student.TimetableManager;
import com.rabbiter.cm.service.BaseService;
import com.rabbiter.cm.model.vo.response.ResultVO;
import org.springframework.stereotype.Service;

@Service("student_timetableService")
public class TimetableService extends BaseService {
    private final TimetableManager manager;

    public TimetableService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        Integer studentId = getUserId();
        return result(manager.listStudentTimetable(studentId));
    }
}
