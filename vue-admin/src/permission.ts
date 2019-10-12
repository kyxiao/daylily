import router from "./router";
import NProgress from "nprogress";
import "nprogress/nprogress.css";
import { Message } from "element-ui";
import { Route } from "vue-router";
import { UserModule } from "@/store/modules/user";
import { PermissionModule } from "@/store/modules/permission";

NProgress.configure({ showSpinner: false });

const whiteList = ["/login"];

router.beforeEach(async (to: Route, _: Route, next: any) => {
  NProgress.start();
  if (UserModule.token) {
    if (to.path === "/login") {
      next({ path: "/" });
      NProgress.done();
    } else {
      if (UserModule.roles.length === 0) {
        try {
          await UserModule.GetUserInfo();
          const roles = UserModule.roles;
          PermissionModule.GenerateRoutes(roles);
          router.addRoutes(PermissionModule.dynamicRoutes);
          next({ ...to, replace: true });
        } catch (err) {
          UserModule.ResetToken();
          Message.error(err || "Has Error");
          next(`/login?redirect=${to.path}`);
          NProgress.done();
        }
      } else {
        next();
      }
    }
  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      next();
    } else {
      next(`/login?redirect=${to.path}`);
      NProgress.done();
    }
  }
});

router.afterEach((to: Route) => {
  NProgress.done();
});
