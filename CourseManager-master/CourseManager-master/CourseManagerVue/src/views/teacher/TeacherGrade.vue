<template>
    <div class="grade-wrap">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <b style="font-size: 22px"> 成绩录入</b>
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
                            placeholder="学生名"
                            v-model="queryForm.studentName"
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
                    <el-table-column label="选课Id" prop="studentCourseId" />
                    <el-table-column label="课程名" prop="courseName" />
                    <el-table-column label="学生姓名" prop="studentName" />
                    <el-table-column label="日常分" prop="dailyScore" />
                    <el-table-column label="笔试分" prop="examScore" />
                    <el-table-column label="成绩" prop="score" />
                    <el-table-column
                        align="center"
                        label="操作"
                        width="200px"
                        fixed="right"
                    >
                        <template slot-scope="scope">
                            <el-button
                                @click="edit(scope.row.studentCourseId)"
                                type="success"
                                style="font-size: 18px"
                                :disabled="!allowGrade"
                            >
                                评分
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

            <el-dialog :visible.sync="editing" title="编辑" width="30%">
                <el-form :model="entityForm" label-width="70px" ref="form">
                    <el-form-item label="选课Id">
                        <el-input
                            disabled
                            type="number"
                            v-model="entityForm.studentCourseId"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="日常成绩">
                        <el-input
                            type="number"
                            v-model="entityForm.dailyScore"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="笔试成绩">
                        <el-input
                            type="number"
                            v-model="entityForm.examScore"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="总成绩">
                        <el-input
                            type="number"
                            v-model="entityForm.score"
                        ></el-input>
                    </el-form-item>
                </el-form>
                <span class="dialog-footer" slot="footer">
                    <el-button
                        @click="save"
                        type="primary"
                        style="font-size: 18px"
                        >
                        确 定</el-button
                    >
                    <el-button @click="editing = false" style="font-size: 18px"
                        >
                        取 消</el-button
                    >
                </span>
            </el-dialog>
        </div>
    </div>
</template>

<script>
import * as api from "../../api/teacher/grade";
import * as OptionApi from "../../api/option";

export default {
    name: "TeacherGrade",
    data() {
        return {
            queryForm: {
                courseName: "",
                studentName: "",
            },
            entityForm: {},
            tableData: [],
            pageSize: api.pageSize,
            pageCount: 1,
            pageIndex: 1,
            editing: false,
            allowGrade: true,
        };
    },
    methods: {
        query() {
            api.getPageCount(
                this.queryForm.courseName,
                this.queryForm.studentName
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
                this.queryForm.studentName
            ).then((res) => {
                this.tableData = res;
            });
        },
        edit(id) {
            api.get(id).then((res) => {
                this.entityForm = res;
                this.editing = true;
            });
        },
        save() {
            api.update(this.entityForm).then(() => {
                this.$message.success("成功");
                this.getPage(this.pageIndex);
                this.editing = false;
            });
        },
    },
    created() {
        this.query();
    },
    mounted() {
        OptionApi.getAllowTeacherGrade().then((res) => {
            this.allowGrade = res;
        });
    },
};
</script>

<style scoped></style>
