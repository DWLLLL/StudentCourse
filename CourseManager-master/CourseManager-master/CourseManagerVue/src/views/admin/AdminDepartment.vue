<template>
    <div class="department-wrap">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <b style="font-size: 22px"> 院系管理</b>
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>

        <div class="container">
            <div class="query-form">
                <el-row :gutter="20">
                    <el-col :span="2">
                        <el-button @click="create" style="font-size: 18px"
                            > 创建</el-button
                        >
                    </el-col>
                    <el-col :offset="13" :span="6">
                        <el-input
                            @keyup.enter.native="query"
                            placeholder="系名"
                            v-model="queryForm.name"
                        />
                    </el-col>
                    <el-col :span="3">
                        <el-button @click="query" type="primary" style="font-size: 18px;">
                             搜索
                        </el-button>
                    </el-col>
                </el-row>
            </div>

            <div class="table">
                <el-table :data="tableData" stripe>
                    <el-table-column label="系Id" prop="id" />
                    <el-table-column label="系名" prop="name" />
                    <el-table-column label="专业数" prop="majorCount" />
                    <el-table-column label="教师数" prop="teacherCount" />
                    <el-table-column
                        align="center"
                        label="操作"
                        width="250px"
                        fixed="right"
                    >
                        <template slot-scope="scope">
                            <el-button
                                @click="edit(scope.row.id)"
                                type="success" style="font-size: 18px;"
                            > 编辑
                            </el-button>
                            <el-button
                                @click="deleteItem(scope.row.id)"
                                type="danger" style="font-size: 18px;"
                            > 删除
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
                    <el-form-item label="系名">
                        <el-input v-model="entityForm.name"></el-input>
                    </el-form-item>
                </el-form>
                <span class="dialog-footer" slot="footer">
                    <el-button
                        @click="save"
                        type="primary"
                         style="font-size: 18px;"
                    >
                        确 定</el-button
                    >
                    <el-button @click="editing = false" style="font-size: 18px;"> 取 消</el-button>
                </span>
            </el-dialog>
        </div>
    </div>
</template>

<script>
import * as api from "../../api/admin/department";

export default {
    name: "AdminDepartment",
    data() {
        return {
            queryForm: {
                name: "",
            },
            entityForm: {},
            tableData: [],
            pageSize: api.pageSize,
            pageCount: 1,
            pageIndex: 1,
            editing: false,
        };
    },
    methods: {
        query() {
            api.getPageCount(this.queryForm.name).then((res) => {
                this.pageCount = res;
                this.pageIndex = 1;
                this.getPage(1);
            });
        },
        getPage(pageIndex) {
            api.getPage(pageIndex, this.queryForm.name).then((res) => {
                this.tableData = res;
            });
        },
        create() {
            this.entityForm = {
                id: -1,
                name: "",
            };
            this.editing = true;
        },
        edit(id) {
            api.get(id).then((res) => {
                this.entityForm = res;
                this.editing = true;
            });
        },
        save() {
            if (this.entityForm.id === -1) {
                api.create(this.entityForm).then(() => {
                    this.finishSave();
                });
            } else {
                api.update(this.entityForm).then(() => {
                    this.finishSave();
                });
            }
        },
        finishSave() {
            this.$message.success("成功");
            this.getPage(this.pageIndex);
            this.editing = false;
        },
        deleteItem(id) {
            api.deleteItem(id).then(() => {
                this.$message.success("删除成功");
                this.getPage(this.pageIndex);
            });
        },
    },
    created() {
        this.query();
    },
};
</script>

<style scoped></style>
