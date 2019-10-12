import {
  VuexModule,
  Module,
  Mutation,
  Action,
  getModule
} from "vuex-module-decorators";
import { getToken, setToken, removeToken } from "@/utils/cookies";
import { login, getUserInfo } from "@/api/users";
import store from "@/store";

export interface IUserState {
  token: string;
  roles: string[];
}

@Module({ dynamic: true, store, name: "user" })
class User extends VuexModule implements IUserState {
  public token = getToken() || "";
  public roles: string[] = [];

  @Mutation
  private SET_TOKEN(token: string) {
    this.token = token;
  }

  @Mutation
  private SET_ROLES(roles: string[]) {
    this.roles = roles;
  }

  @Action
  public async Login(userInfo: { username: string; password: string }) {
    let { username, password } = userInfo;
    username = username.trim();
    const { data } = await login({ username, password });
    setToken(data.accessToken);
    this.SET_TOKEN(data.accessToken);
  }

  @Action
  public ResetToken() {
    removeToken();
    this.SET_TOKEN("");
    this.SET_ROLES([]);
  }

  @Action
  public async GetUserInfo() {
    if (this.token === "") {
      throw Error("GetUserInfo: token is undefined!");
    }
    const { data } = await getUserInfo({});
    if (!data) {
      throw Error("Verification failed, please Login again.");
    }
    const { roles } = data.user;
    if (!roles || roles.length <= 0) {
      throw Error("GetUserInfo: roles must be a non-null array!");
    }
    this.SET_ROLES(roles);
  }
}

export const UserModule = getModule(User);
