<template>
  <div>
    <div>
      <!-- <sidebar class="sidebar-container" /> -->
      <div>
        <div>
          <!-- <navbar /> -->
          <!-- <tags-view v-if="showTagsView" /> -->
        </div>
        <app-main />
        <!--         
        <right-panel v-if="showSettings">
          <settings />
        </right-panel>
        -->
      </div>
    </div>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { AppMain } from "./components";
@Component({
  name: "Layout",
  components: {
    AppMain
  }
})
export default class Layout extends Vue {}
</script>
