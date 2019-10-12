import Vue from "vue";
import Vuex from "vuex";

import { IAppState } from "./modules/app";
import { IUserState } from "./modules/user";
import { IPermissionState } from "./modules/permission";

Vue.use(Vuex);

export interface IRootState {
  app: IAppState;
  user: IUserState;
  permission: IPermissionState;
}

export default new Vuex.Store<IRootState>({});
