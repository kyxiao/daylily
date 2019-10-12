<template>
  <div>
    <router-view :key="key" />
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
@Component({
  name: "AppMian"
})
export default class AppMian extends Vue {
  get key() {
    return this.$route.path;
  }
}
</script>
