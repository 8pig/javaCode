// vue.config.js
module.exports = {
    devServer: {
        open: true,
        port: 8082,
        proxy: 'http://localhost:8080'
    }
}