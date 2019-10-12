module.exports = {
  devServer: {
    proxy: {
      [process.env.VUE_APP_BASE_API]: {
        target: "http://localhost:8080/jeecg-boot",
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          ["^" + process.env.VUE_APP_BASE_API]: ""
        }
      }
    }
  }
};
