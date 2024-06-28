package com.rabbiter.cm.model.vo.response.table;

public class ClassItemVO {
    private Integer id;
    private String name;
    private Integer grade;
    private String departmentName;
    private String majorName;

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "ClassItemVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", departmentName='" + departmentName + '\'' +
                ", majorName='" + majorName + '\'' +
                '}';
    }
}
