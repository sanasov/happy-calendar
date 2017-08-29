const webpack = require('webpack');
const path = require('path');
const SRC_DIR = path.resolve(__dirname, 'src/main/client');
const TOMCAT_DIR = path.resolve(__dirname, 'C:\\apache-tomcat-9.0.0.M22\\webapps\\hp\\resources\\app');
const NODE_MODULE_ROOT = path.resolve(__dirname, 'node_modules');

function isExternal(module) {
    if (!module.userRequest) {
        return false;
    }
    return module.userRequest.indexOf('node_modules') >= 0;
}

const commonConfig = {

    devtool: 'inline-cheap-module-source-map', // for view src in browser
    watch: true,
    context: SRC_DIR,
    entry: {
        app: './main.ts'
    },
    resolve: {
        modules: [
            SRC_DIR,
            NODE_MODULE_ROOT
        ],
        extensions: ['.tsx', '.ts', '.js', '.json', '.css', '.scss']
    },
    output:
        {
            path: TOMCAT_DIR,
            filename: 'bundle.js',
            publicPath: '/app/'
        },
    module: {
        loaders: [
            {
                test: /\.ts$/,
                use: [
                    'awesome-typescript-loader',
                    'angular2-template-loader'
                ]
            },
            {
                test: /\.html$/,
                exclude: /node_modules/,
                use: 'html-loader'
            },
            {
                test: /\.scss$/,
                exclude: /node_modules/,
                use: ['to-string-loader', 'css-loader', 'sass-loader']
            },
        ]
    },
    plugins:
        [
            new webpack.optimize.CommonsChunkPlugin({
                name: 'vendor',
                filename: "vendor.js",
                minChunks: (module) => isExternal(module)
            })
        ]
}
module.exports = commonConfig;