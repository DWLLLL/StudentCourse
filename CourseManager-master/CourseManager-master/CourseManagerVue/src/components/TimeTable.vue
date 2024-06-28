<template>
  <div class="timetable">
    <table>
      <thead>
        <tr>
          <th>时间</th>
          <th :key="index" v-for="(item, index) in tableData.length">
            {{ "周" + digital2Chinese(item, "week") }}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr :key="index" v-for="(lesson, index) in tableData[0].length">
          <td>
            <p>{{ "第" + digital2Chinese(lesson) + "节" }}</p>
          </td>
          <td :key="courseIndex" v-for="(course, courseIndex) in tableData">
            <span class="course-name">
              <b>{{ tableData[courseIndex][index].courseName }}</b>
            </span>
            <p class="teacher-name" v-if="tableData[courseIndex][index].teacherName != ''">
              教师：{{ tableData[courseIndex][index].teacherName }}
            </p>
            <p class="location-name">
              {{ tableData[courseIndex][index].location }}
            </p>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "TimeTable",
  data() {
    return {
      tableData: [
        [
          {
            courseName: "",
            teacherName: "",
            location: ""
          }
        ]
      ]
    };
  },
  methods: {
    updateData(data) {
      this.clearTable();
      for (let i = 0; i < data.length; i++) {
        this.setLesson(data[i]);
      }
    },
    setLesson(item) {
      let split = item.time.split("-");
      let week = parseInt(split[0]);
      let lesson = parseInt(split[1]);
      let length = parseInt(split[2]);
      for (let i = 0; i < length; i++) {
        this.tableData[week - 1][lesson - 1 + i] = {
          courseName: item.courseName,
          teacherName: item.teacherName,
          location: item.location
        };
      }
    },
    clearTable() {
      let table = [];
      for (let i = 0; i < 7; i++) {
        let arr = [];
        for (let i2 = 0; i2 < 10; i2++) {
          arr.push({
            courseName: "",
            teacherName: "",
            location: ""
          });
        }
        table.push(arr);
      }
      this.tableData = table;
    },
    digital2Chinese(num, identifier) {
      const character = [
        "零",
        "一",
        "二",
        "三",
        "四",
        "五",
        "六",
        "七",
        "八",
        "九",
        "十"
      ];
      return identifier === "week" && num === 7 ? "日" : character[num];
    }
  },
  created() {
    this.clearTable();
  }
};
</script>

<style lang="scss" scoped>
table {
  table-layout: fixed;
  width: 100%;

  thead {
    background-color: #3CB371;
    th {
      color: #fff;
      line-height: 25px;
      font-weight: normal;
    }
  }

  tbody {
    background-color: #90EE90;

    td {
      line-height: 0;
      color: black;
      height: 50px;
      padding-top: 5px;

      span {
        line-height: 0.9;
      }
    }

    .course-name {
      color: #000;
      font-size: 16px;
      font-weight: 200;
    }
  }

  th,
  td {
    width: 60px;
    padding: 2px 2px;
    font-size: 12px;
    text-align: center;
  }

  tr td:first-child {
    color: #333;

    .period {
      font-size: 8px;
    }
  }
}
</style>
