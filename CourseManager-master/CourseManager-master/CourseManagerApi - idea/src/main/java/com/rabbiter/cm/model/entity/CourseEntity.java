package com.rabbiter.cm.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@TableName("rc_course")
public class CourseEntity {
    public static final String ID = "course_id";
    public static final String TEACHER_ID = "course_teacher_id";
    public static final String NAME = "course_name";
    public static final String GRADE = "course_grade";
    public static final String TIME = "course_time";
    public static final String LOCATION = "course_location";
    public static final String CREDIT = "course_credit";
    public static final String TYPE = "course_type";
    public static final String SELECTED_COUNT = "course_selected_count";
    public static final String MAX_SIZE = "course_max_size";
    public static final String EXAM_DATE = "course_exam_date";
    public static final String EXAM_LOCATION = "course_exam_location";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择授课教师")
    @TableField(TEACHER_ID)
    private Integer teacherId;

    @NotBlank(message = "课程名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @Range(min = 1980, max = 2999, message = "年级范围必须在1980-2999之间")
    @TableField(GRADE)
    private Integer grade;

    @Pattern(regexp = "[1-7]-[1-9]-[1-4]", message = "课程最长时间为4节")
    @TableField(TIME)
    private String time;

    @NotBlank(message = "上课地点不能为空")
    @TableField(LOCATION)
    private String location;

    @NotNull
    @Range(min = 1, max = 20, message = "学分必须在1-20之间")
    @TableField(CREDIT)
    private Integer credit;

    @TableField(SELECTED_COUNT)
    private Integer selectedCount;

    @NotNull
    @Range(min = 0, message = "容量不能为负数")
    @TableField(MAX_SIZE)
    private Integer maxSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField(value = EXAM_DATE, updateStrategy = FieldStrategy.IGNORED)
    private Date examDate;

    @TableField(value = EXAM_LOCATION, updateStrategy = FieldStrategy.IGNORED)
    private String examLocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getSelectedCount() {
        return selectedCount;
    }

    public void setSelectedCount(Integer selectedCount) {
        this.selectedCount = selectedCount;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
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
        return "CourseEntity{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", credit=" + credit +
                ", selectedCount=" + selectedCount +
                ", maxSize=" + maxSize +
                ", examDate=" + examDate +
                ", examLocation='" + examLocation + '\'' +
                '}';
    }
}
