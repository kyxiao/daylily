import Vue from "vue";
import Router, { RouteConfig } from "vue-router";
import Layout from "@/layout/index.vue";

Vue.use(Router);

export const constantRoutes: RouteConfig[] = [
  {
    path: "/",
    component: Layout,
    redirect: "/dashboard",
    children: [
      {
        path: "dashboard",
        name: "Dashboard",
        component: () =>
          import(
            /* webpackChunkName: "dashboard" */ "@/views/dashboard/index.vue"
          ),
        meta: {
          title: "dashboard",
          icon: "dashboard",
          affix: true
        }
      }
    ]
  },
  {
    path: "/login",
    component: () =>
      import(/* webpackChunkName: "login" */ "@/views/login/index.vue"),
    meta: { hidden: true }
  }
];

export const asyncRoutes: RouteConfig[] = [];

const createRouter = () =>
  new Router({
    mode: "history",
    scrollBehavior: (to, from, savedPosition) => {
      if (savedPosition) {
        return savedPosition;
      } else {
        return { x: 0, y: 0 };
      }
    },
    base: process.env.BASE_URL,
    routes: constantRoutes
  });

const router = createRouter();

export function resetRouter() {
  const newRouter = createRouter();
  (router as any).matcher = (newRouter as any).matcher;
}

export default router;
