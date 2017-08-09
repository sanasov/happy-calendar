const webpack = require('webpack');
const path = require('path');

const SRC_DIR = path.resolve(__dirname, 'src/main/client');
const DEST_DIR = path.resolve(__dirname, 'src/main/webapp/resources/app');
const NODE_MODULE_ROOT = path.resolve(__dirname, 'node_modules');

function isExternal(module) {
    if (!module.userRequest) {
        return false;
    }
    debugger
    return module.userRequest.indexOf('node_modules') >= 0;
}

module.exports = {
    devtool: 'cheap-module-eval-source-map', // for view src in browser
    context: SRC_DIR,
    entry: {
        app: './index.js'
    },
    resolve: {
        modules: [
            SRC_DIR,
            NODE_MODULE_ROOT
        ],
        // extensions: ['.js', '.json', 'html']
    },
    output: {
        path: DEST_DIR,
        filename: 'bundle.js',
        publicPath: '/app/'
    },
    // module: {
    //     rules: [{
    //         test: /\.js$/,
    //         loader: 'babel-loader',
    //         include: [
    //             // Your app
    //             path.join(__dirname, SRC_DIR),
    //             // Modules with `module` field or `engines.node > 0.10`
    //             path.join(__dirname, NODE_MODULE_ROOT)
    //         ]
    //     }]
    // },
    plugins: [
        new webpack.optimize.CommonsChunkPlugin({
            name: 'commons',
            filename: "commons.js",
            minChunks: (module) => isExternal(module)
        })
    ]
}