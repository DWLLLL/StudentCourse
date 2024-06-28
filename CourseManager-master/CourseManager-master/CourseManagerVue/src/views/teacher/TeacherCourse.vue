<!--
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-06-06 09:09:08
-->
<template>
  <div class="course-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <b style="font-size: 22px;"> 授课查询</b>
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <div class="table">
        <el-table :data="tableData" stripe>
          <el-table-column label="课程Id" prop="id" />
          <el-table-column label="课程名" prop="name" />
          <el-table-column label="年级" prop="grade" />
          <el-table-column label="学分" prop="credit" />
          <el-table-column label="上课时间" prop="time" />
          <el-table-column label="上课地点" prop="location" />
          <el-table-column label="选课人数" prop="selectedCount" />
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/teacher/course";

export default {
  name: "TeacherCourse",
  data() {
    return {
      tableData: []
    };
  },
  methods: {
    getList() {
      api.list().then(res => {
        this.tableData = res;
      });
    }
  },
  created() {
    this.getList();
  }
};
</script>

<style scoped></style>
