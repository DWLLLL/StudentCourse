package com.rabbiter.cm.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class StudentExamItemVO {
    private Integer studentCourseId;
    private String courseName;
    private String teacherName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date examDate;
    private String examLocation;

    public Integer getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(Integer studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getExamLocation() {
        return examLocation;
    }

    public void setExamLocation(String examLocation) {
        this.examLocation = examLocation;
    }

    @Override
    public String toString() {
        return "StudentExamItemVO{" +
                "studentCourseId=" + studentCourseId +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", examDate=" + examDate +
                ", examLocation='" + examLocation + '\'' +
                '}';
    }
}
