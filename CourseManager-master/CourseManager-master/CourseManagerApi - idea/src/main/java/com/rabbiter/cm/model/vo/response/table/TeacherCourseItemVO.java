package com.rabbiter.cm.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TeacherCourseItemVO {
    private Integer id;
    private String name;
    private Integer grade;
    private Integer credit;
    private String time;
    private String location;
    private Integer selectedCount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date examDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSelectedCount() {
        return selectedCount;
    }

    public void setSelectedCount(Integer selectedCount) {
        this.selectedCount = selectedCount;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    @Override
    public String toString() {
        return "TeacherCourseItemVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", credit=" + credit +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", selectedCount=" + selectedCount +
                ", examDate=" + examDate +
                '}';
    }
}
