module.exports = {
  lintOnSave: false,
  devServer: { // https://github.com/vuejs/vue-cli/blob/dev/docs/cli-service.md#configuring-proxy
      '/api': {
        target: 'http://localhost:3030',
        ws: true,
        changeOrigin: true
  }
}