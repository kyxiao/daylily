<template>
  <div class="about">
    <h1>This is an about page</h1>
    <el-table v-loading="listLoading" :data="list" border style="width: 100%">
      <el-table-column prop="id" label="序号"></el-table-column>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column label="操作">
        <!-- <template slot-scope="scope">
          <el-button type="primary" size="mini" icon="el-icon-edit" @click="handleEdit(scope.row)">修改</el-button>
          <el-button type="primary" size="mini" icon="el-icon-picture-outline" @click="handleAtta(scope.row)">图片</el-button>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="handleDel(scope.row)">删除</el-button>
        </template> -->
      </el-table-column>
    </el-table>
  </div>
</template>
<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { Sutdent } from '@/api/types'
import { getfindAll } from '@/api/student'
@Component({
  name: 'About'
})
export default class extends Vue {
  private listLoading = true
  private list: Sutdent[] = []
  private listQuery = {
    page: 1,
    rows: 10
  }
  created() {
    this.getList()
  }
  private async getList() {
    this.listLoading = true
    const { data } = await getfindAll(this.listQuery)
    this.list = data
    this.listLoading = false
  }
}
</script>
