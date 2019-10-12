// import qs from "qs";
import request from "@/utils/request";

export const login = (data: any) =>
  request({
    url: "/sys/login",
    method: "post",
    // 2019-10-12 传参方式的处理
    // headers: { "content-type": "application/x-www-form-urlencoded; charset=UTF-8" },
    // data: qs.stringify(parameter)
    data
  });

export const getUserInfo = (data: any) =>
  request({
    url: "/users/info",
    method: "post",
    data
  });
