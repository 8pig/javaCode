// vue.config.js
module.exports = {
  publicPath: './',
  outputDir: 'dist',  //build输出目录
  assetsDir: 'assets', //静态资源目录（js, css, img）
  lintOnSave: false, //是否开启eslint
  devServer: {
    proxy: {
      '/': {
        target: 'http://localhost:3000',
        ws: false,//是否代理websockets
        changeOrigin: true,   // 设置同源  默认false，是否需要改变原始主机头为目标URL
        pathRewrite: {  //重写路径 比如'/api/aaa/ccc'重写为'/aaa/ccc'
          '^/api': ''
        }
      }
    }
  }
};
