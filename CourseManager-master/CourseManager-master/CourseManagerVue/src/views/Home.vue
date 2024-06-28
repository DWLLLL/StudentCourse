<!--
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-06-06 09:09:08
-->
<template>
    <div id="home">
        <h2 class="welcome">欢迎使用课程管理系统</h2>
        <div class="welcome-container" v-if="this.$store.state.status.userType == 3">
            <h3 class="welcome"> 管理员端</h3>
        </div>
        <div class="welcome-container" v-if="this.$store.state.status.userType == 2">
            <h3 class="welcome"> 教师端</h3>
        </div>
        <div class="welcome-container" v-if="this.$store.state.status.userType == 1">
            <h3 class="welcome"> 学生端</h3>
        </div>
    </div>
</template>

<script>
export default {
    name: "Home",
    data() {
        return {
            tableData: [],
        };
    },
    created() {},
};
</script>

<style scoped>
.home-wrap {
    height: 100%;
    width: 100%;
}

.main-wrap {
    margin-top: 10px;
    height: 100%;
    width: 100%;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
}

.home-container {
    height: 100%;
    width: 90%;
    margin: auto;
}

.home-aside {
    height: 100%;
}

.aside-container {
    width: 90%;
    margin-left: auto;
    margin-right: auto;
    height: 200px;
    margin-top: 20px;
}

.aside-img {
    width: 100%;
}

.aside-title {
    color: #333;
    font-size: 18px;
}

.aside-content {
    font-size: 12px;
    color: #999;
}

#home {
    /* position: fixed; */
    top: 0;
    left: 0;
    width: 100%;
    overflow-y: auto;
    height: 95%;
    background: url("../assets/10.jpg") center top / cover no-repeat;
    text-align: center;
    padding-top: 50px;
}

.welcome {
    font-size: 36px;
    font-weight: 800;
    color: white;
    -webkit-text-stroke: 1px black;
}

.welcome-container {
    font-size: 26px;
    color: white;
    -webkit-text-stroke: 1px black;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>
