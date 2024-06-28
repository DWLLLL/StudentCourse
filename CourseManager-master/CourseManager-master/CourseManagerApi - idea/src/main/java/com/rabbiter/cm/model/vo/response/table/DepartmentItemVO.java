package com.rabbiter.cm.model.vo.response.table;

public class DepartmentItemVO {
    private Integer id;
    private String name;
    private Integer majorCount;
    private Integer teacherCount;

    public DepartmentItemVO(Integer id, String name, Integer majorCount, Integer teacherCount) {
        this.id = id;
        this.name = name;
        this.majorCount = majorCount;
        this.teacherCount = teacherCount;
    }

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

    public Integer getMajorCount() {
        return majorCount;
    }

    public void setMajorCount(Integer majorCount) {
        this.majorCount = majorCount;
    }

    public Integer getTeacherCount() {
        return teacherCount;
    }

    public void setTeacherCount(Integer teacherCount) {
        this.teacherCount = teacherCount;
    }

    @Override
    public String toString() {
        return "DepartmentItemVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", majorCount=" + majorCount +
                ", teacherCount=" + teacherCount +
                '}';
    }
}
