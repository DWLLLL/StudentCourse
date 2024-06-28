import UserType from "./userType";
import Permission from "./permission";

let SideBarItem = {};

SideBarItem.items = [
  {
    icon: "iconfont icon-r-home",
    index: "/student",
    title: "首页",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-edit",
    index: "/student/course/select",
    title: "选课",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-yes",
    index: "/student/course",
    title: "已选课程管理",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-paper",
    index: "/student/timetable",
    title: "课表查询",
    userType: UserType.student,
    permission: Permission.no
  },
  // {
  //   icon: "el-icon-fa fa-eye",
  //   index: "/student/exam",
  //   title: "考试查询",
  //   userType: UserType.student,
  //   permission: Permission.no
  // },
  {
    icon: "iconfont icon-r-find",
    index: "/student/score",
    title: "成绩查询",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-setting",
    index: "/student/info",
    title: "信息维护",
    userType: UserType.student,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-home",
    index: "/teacher",
    title: "首页",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-find",
    index: "/teacher/course",
    title: "授课查询",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-paper",
    index: "/teacher/timetable",
    title: "教师课表",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-add",
    index: "/teacher/grade",
    title: "成绩录入",
    userType: UserType.teacher,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-home",
    index: "/admin",
    title: "首页",
    userType: UserType.admin,
    permission: Permission.no
  },
  {
    icon: "iconfont icon-r-building",
    index: "/admin/department",
    title: "院系管理",
    userType: UserType.admin,
    permission: Permission.department
  },
  {
    icon: "iconfont icon-r-mark1",
    index: "/admin/major",
    title: "专业管理",
    userType: UserType.admin,
    permission: Permission.major
  },
  {
    icon: "iconfont icon-r-team",
    index: "/admin/class",
    title: "班级管理",
    userType: UserType.admin,
    permission: Permission.class
  },
  {
    icon: "iconfont icon-r-paper",
    index: "/admin/course",
    title: "课程管理",
    userType: UserType.admin,
    permission: Permission.course
  },
  {
    icon: "iconfont icon-r-edit",
    index: "/admin/student/course",
    title: "选课管理",
    userType: UserType.admin,
    permission: Permission.studentCourse
  },
  {
    icon: "iconfont icon-r-user2",
    index: "/admin/student",
    title: "学生管理",
    userType: UserType.admin,
    permission: Permission.student
  },
  {
    icon: "iconfont icon-r-user3",
    index: "/admin/teacher",
    title: "教师管理",
    userType: UserType.admin,
    permission: Permission.teacher
  },
  {
    icon: "iconfont icon-r-user1",
    index: "/admin/admin",
    title: "管理员管理",
    userType: UserType.admin,
    permission: Permission.admin
  },
];

export default SideBarItem;
