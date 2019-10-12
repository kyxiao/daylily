<template>
  <div>
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      autocomplete="on"
      label-position="left"
      label-width="80px"
    >
      <el-form-item label="帐户名">
        <el-input
          v-model="loginForm.username"
          placeholder="请输入帐户名"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input
          v-model="loginForm.password"
          type="password"
          placeholder="请输入密码"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleLogin">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { Form as ElForm } from "element-ui";
import { UserModule } from "@/store/modules/user";
@Component({
  name: "Login"
})
export default class Login extends Vue {
  private loginForm = {
    username: "admin",
    password: "111111"
  };
  private loginRules = {};
  private loading = false;
  private handleLogin() {
    (this.$refs.loginForm as ElForm).validate(async (valid: boolean) => {
      if (valid) {
        this.loading = true;
        await UserModule.Login(this.loginForm);
        this.$router.push({
          path: "/"
        });
        this.loading = false;
      } else {
        return false;
      }
    });
  }
}
</script>
