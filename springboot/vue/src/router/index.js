import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  //使用 createWebHistory 创建的历史记录对象。获取应用的基础路径
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [//routes中放路由规则
    { 
      path: '/', // 根路径
      name: 'Manager',
      component: () => import('@/web/Manager.vue'), // 懒加载组件
      redirect: '/login', // 重定向到 /login 路径
      children: [// 嵌套路由
        { 
          path: 'home', // home 子路由 
          name: 'Home',
          component: () => import('@/web/Home.vue')
        }, 
        { 
          path: 'course', 
          name: 'Course', 
          component: () => import('@/web/Course.vue')
        },
        { 
          path: 'student', 
          name: 'Student', 
          component: () => import('@/web/Student.vue')
        },
        { 
          path: 'person', 
          name: 'Person', 
          component: () => import('@/web/Person.vue')
        },
        { 
          path: 'file', 
          name: 'File', 
          component: () => import('@/web/Doc.vue')
        },
        { 
          path: 'doc', 
          name: 'Doc', 
          component: () => import('@/web/Doc.vue')
        },
        { 
          path: 'docStudent', 
          name: 'DocStudent', 
          component: () => import('@/web/DocStudent.vue')
        },
        { 
          path: 'studentCourse', 
          name: 'StudentCourse', 
          component: () => import('@/web/StudentCourse.vue')
        },
        { 
          path: 'courseList', 
          name: 'CourseList', 
          component: () => import('@/web/CourseList.vue')
        },
      ]
    },
    { 
      path: '/login', 
      name: 'Login', 
      component: () => import('@/web/Login.vue')
    },
    { 
      path: '/register', 
      name: 'Register', 
      component: () => import('@/web/Register.vue')
    },
    { 
      path: '/reset', 
      name: 'Reset', 
      component: () => import('@/web/Reset.vue')
    },
  ]
})
// 导出路由器实例，以便在主应用中引入和使用
export default router;
