<template>
    <div class="course-select-wrap">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <b style="font-size: 22px"> 选课</b>
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>

        <div class="container">
            <div class="query-form">
                <el-row :gutter="20">
                    <el-col :offset="15" :span="3">
                        <el-input
                            @keyup.enter.native="query"
                            placeholder="课程名"
                            v-model="queryForm.courseName"
                        />
                    </el-col>
                    <el-col :span="3">
                        <el-input
                            @keyup.enter.native="query"
                            placeholder="教师名"
                            v-model="queryForm.teacherName"
                        />
                    </el-col>
                    <el-col :span="3">
                        <el-button
                            @click="query"
                            type="primary"
                            style="font-size: 18px"
                        >
                             搜索
                        </el-button>
                    </el-col>
                </el-row>
            </div>

            <div class="table">
                <el-table :data="tableData" stripe>
                    <el-table-column label="课程Id" prop="courseId" />
                    <el-table-column
                        label="课程名"
                        prop="courseName"
                        width="180px"
                    />
                    <el-table-column label="教师" prop="teacherName" />
                    <el-table-column label="学分" prop="credit" />
                    <el-table-column
                        align="center"
                        label="上课时间"
                        prop="time"
                        width="130px"
                    />
                    <el-table-column label="已选人数" prop="selectedCount" />
                    <el-table-column label="课程容量" prop="maxSize" />
                    <el-table-column
                        align="center"
                        label="操作"
                        width="200px"
                        fixed="right"
                    >
                        <template slot-scope="scope">
                            <el-button
                                @click="select(scope.row.courseId)"
                                :disabled="!allowSelect"
                                type="success"
                                style="font-size: 18px"
                            >
                                 选修
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </div>

            <el-row justify="center" type="flex" style="margin: 5px 0 5px 0">
                <el-pagination
                    :current-page.sync="pageIndex"
                    :page-size="pageSize"
                    :total="pageSize * pageCount"
                    @current-change="getPage"
                    background
                    layout="prev, pager, next"
                >
                </el-pagination>
            </el-row>
        </div>
    </div>
</template>

<script>
import * as api from "../../api/student/courseSelect";
import * as OptionApi from "../../api/option";

export default {
    name: "StudentCourseSelect",
    data() {
        return {
            queryForm: {
                courseName: "",
                teacherName: "",
            },
            tableData: [],
            pageSize: api.pageSize,
            pageCount: 1,
            pageIndex: 1,
            allowSelect: true,
        };
    },
    methods: {
        query() {
            api.getPageCount(
                this.queryForm.courseName,
                this.queryForm.teacherName
            ).then((res) => {
                this.pageCount = res;
                this.pageIndex = 1;
                this.getPage(1);
            });
        },
        getPage(pageIndex) {
            api.getPage(
                pageIndex,
                this.queryForm.courseName,
                this.queryForm.teacherName
            ).then((res) => {
                this.tableData = res;
            });
        },
        select(id) {
            api.select(id).then(() => {
                this.$message.success("选修成功!");
                this.getPage(this.pageIndex);
            });
        },
    },
    created() {
        this.query();

    },
    mounted() {
      
        OptionApi.getAllowStudentSelect().then((res) => {
            this.allowSelect = res;
        });
    }
};
</script>

<style scoped></style>
