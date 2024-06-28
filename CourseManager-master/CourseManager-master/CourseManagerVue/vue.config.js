/*
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-07-08 21:30:02
 */
module.exports = {
    lintOnSave: false, // 关闭eslint校验
    devServer: {
        port: 9262,
        overlay: { // 关闭eslint校验
            warning: false,
            errors: false
        },
    }
};


