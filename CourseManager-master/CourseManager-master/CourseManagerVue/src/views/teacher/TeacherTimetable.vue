<!--
 * @Description:
 * @Author: Rabbiter
 * @Date: 2023-06-06 09:09:08
-->
<template>
  <div class="timetable-wrap">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <b style="font-size: 22px;"> 教师课表</b>
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <div class="container">
      <time-table ref="timeTable"></time-table>
    </div>
    <div class="export-button">
      <el-button type="primary" @click="exportToExcel">导出为 Excel</el-button>
    </div>
  </div>
</template>

<script>
import * as api from "../../api/teacher/timetable";
import TimeTable from "../../components/TimeTable";
import * as XLSX from "xlsx";

export default {
  name: "TeacherTimetable",
  components: { TimeTable },
  created() {
    api.get().then((res) => {
      this.$refs.timeTable.updateData(res);
      this.tableData = res; // 保存表格数据
    });
  },
  data() {
    return {
      tableData: [], // 存储表格数据
    };
  },
  methods: {
    parseTime(time) {
      const [day, start, duration] = time.split('-').map(Number);
      return { day, start, duration };
    },
    exportToExcel() {
      // 创建工作簿
      const wb = XLSX.utils.book_new();

      // 创建空的课程表数组（每周7天，每天10节课）
      const table = Array.from({ length: 10 }, () => Array(7).fill(''));

      // 表头
      const header = ["时间", "周一", "周二", "周三", "周四", "周五", "周六", "周日"];
      table.unshift(header);

      // 填充课程表数据
      this.tableData.forEach((course) => {
        const { day, start, duration } = this.parseTime(course.time);
        const courseInfo = `${course.courseName}\n教师: ${course.teacherName}\n${course.location}`;
        for (let i = 0; i < duration; i++) {
          table[start + i][day - 1] = courseInfo;
        }
      });

      // 添加时间段标签
      const timeSlots = [
        "第一节",
        "第二节",
        "第三节",
        "第四节",
        "第五节",
        "第六节",
        "第七节",
        "第八节",
        "第九节",
        "第十节"
      ];
      for (let i = 1; i <= 10; i++) {
        table[i][0] = timeSlots[i - 1];
      }

      // 将数据转换为工作表
      const ws = XLSX.utils.aoa_to_sheet(table);

      // 将工作表添加到工作簿
      XLSX.utils.book_append_sheet(wb, ws, "课表");

      // 生成 Excel 文件并触发下载
      XLSX.writeFile(wb, "课表.xlsx");
    },
  },
};
</script>

<style scoped>
.export-button {
  margin-top: 20px;
  text-align: right;
}
</style>
