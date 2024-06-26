<template>
  <div class="container0">
    <div class="container1">
      <div class="form-and-image">
        <div class="form-content">
          <div class="logo-container">
            <img src="@/images/YTU.png" alt="烟大logo" class="logo-image">
          </div>

          <el-form :model="data.form" ref="formRef" :rules="formRules" class="login-form">
            <!-- 角色选择选项卡 -->
            <el-tabs v-model="data.form.role" stretch class="custom-tabs">
              <el-tab-pane label="学生登录" name="STUDENT"></el-tab-pane>
              <el-tab-pane label="管理员登录" name="ADMIN"></el-tab-pane>
            </el-tabs>

            <!-- 用户名输入框 -->
            <el-form-item class="custom-margin" prop="username">
              <el-input prefix-icon="User" v-model="data.form.username" placeholder="请输入学号/工号" class="input-large" />
            </el-form-item>

            <!-- 密码输入框 -->
            <el-form-item prop="password">
              <el-input show-password prefix-icon="Lock" v-model="data.form.password" placeholder="请输入密码" class="input-large" />
            </el-form-item>

            <!-- 登录按钮 -->
            <el-form-item>
              <el-button type="primary" class="custom-button large-button" @click="login">登 录</el-button>
            </el-form-item>
          </el-form>

          <div class="register-link">
            <router-link to="/reset" class="white-link">忘记密码</router-link>
            <router-link to="/register" class="white-link">注册账号</router-link>
          </div>

        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from "vue";
import request from "@/utils/request";
import { ElMessage } from "element-plus";
import router from "@/router";


const data = reactive({
  form: {
    role: 'STUDENT',
    username: '',
    password: ''
  }
});

const formRules = reactive({
  username: [{ required: true, message: '请输入学号/工号', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
});

const formRef = ref();

// 处理登录逻辑
const login = () => {
  formRef.value.validate(valid => {
    if (valid) {
      request.post('/login', data.form).then(res => {
            if (res.code === '200') {
              localStorage.setItem('student-user', JSON.stringify(res.data));
              ElMessage.success('登录成功');
              router.push('/home'); // 登录成功后跳转到首页
            } else {
              ElMessage.error(res.msg);
            }
          });
    }
  });
};

</script>

<style scoped>
.container0 {
  min-height: 100vh;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url('@/images/bg3.jpg');
  background-size: cover;
}

.container1 {
  width: auto;
  height: 440px;
  background-color: rgba(0, 0, 0, 0.77);
  box-shadow: rgba(0, 0, 0, 0.6);
  padding: 30px;
  border-top-left-radius: 20px;
  border-bottom-left-radius: 20px;
  border-bottom-right-radius: 20px;
  border-top-left-radius: 20px;
}

.left-side, .right-side {
  flex: 1;
}

.left-side {
  display: flex;
  flex-direction: column;
  justify-content: space-between; /* 确保上下分布 */
}


.logo-container {
  text-align: center;
  margin-bottom: 30px;
}

.logo-image {
  width: 200px;
  height: 60px;
  margin-bottom: -15px;
}

.login-form { }

.input-large {
  font-size: 18px;
  height: 50px;
}

.large-button {
  width: 100%;
  font-size: 20px;
  height: 55px;
}

.register-link {
  display: flex;
  gap: 12px; /* 在链接之间添加间距 */
  margin-top: 10px;
  text-align: left;
  color: #ffffff;
  font-size: 15px;
}

.white-link {
  color: #ffffff;
  text-decoration: none;
}

.custom-button {
  background-color: #002954 !important;
  border-color: #002954 !important;
}

.form-and-image {
  display: flex;
  align-items: center;
}

.custom-tabs >>> .el-tabs__item {
  color: #b6b6b6 !important;
  font-size: 16px !important;
}

.custom-tabs >>> .el-tabs__item.is-active {
  color: #ffffff !important;
}

.custom-tabs >>> .el-tabs__active-bar {
  background-color: #002954 !important;
  transition: all 0.5s;
  height: 3px !important;
}
</style>
