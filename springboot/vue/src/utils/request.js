import { ElMessage } from 'element-plus'
import router from '../router'// 导入自定义的路由器实例
import axios from "axios";// 从 'axios' 导入 axios 库

// 创建一个 axios 实例，配置基本设置
const request = axios.create({
    baseURL: import.meta.env.VITE_BASE_URL,
    timeout: 30000 // 请求超时时间设置为30秒
})

// 添加请求拦截器
// 可以在请求发送前对请求做一些处理
request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    return config
}, error => {
    return Promise.reject(error)// 如果请求出错，返回一个拒绝的 Promise
});

// 添加响应拦截器
// 可以在接口响应后统一处理结果
request.interceptors.response.use(
    response => {
        let res = response.data;// 获取响应数据
        // 如果响应类型是 'blob'（通常是文件下载）
        if (response.config.responseType === 'blob') {
            return res
        }
        // 如果返回的数据是字符串，尝试解析为 JSON 对象
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
        // 如果返回的状态码是 '401'（权限验证不通过）
        if (res.code === '401') {
            ElMessage.error(res.msg);// 显示错误信息
            router.push("/login")// 跳转到登录页面
        }
        return res;// 返回响应数据
    },
    error => {
        console.log('err' + error)// 打印错误信息
        return Promise.reject(error)// 返回一个拒绝的 Promise
    }
)

// 导出自定义的 axios 实例，以便在其他模块中使用
export default request
