const webpack = require('webpack');
const path = require('path');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const SRC_DIR = path.resolve(__dirname, 'src/main/client');
const TOMCAT_DIR = path.resolve(__dirname, 'C:\\apache-tomcat-9.0.0.M22\\webapps\\hp\\resources\\app');
const NODE_MODULE_ROOT = path.resolve(__dirname, 'node_modules');


const styleConfig = {

    devtool: 'inline-cheap-module-source-map', // for view src in browser
    watch: true,
    context: SRC_DIR,
    entry: {
        style: './style/index.sass'
    },
    resolve: {
        modules: [
            SRC_DIR,
            NODE_MODULE_ROOT
        ],
        extensions: ['.css', '.scss', '.sass']
    },
    output:
        {
            path: TOMCAT_DIR,
            filename: 'bundle.css',
            publicPath: '/app/'
        },
    module: {
        loaders: [
            {
                test: /\.(eot|woff|woff2|ttf)$/,
                use: "file-loader?name=../fonts/[name].[ext]&publicPath=./"
            },
            {
                test: /\.svg$/,
                use: "file-loader?name=../img/[name].[ext]&publicPath=./"
            },
            {
                test: /\.(png|jpg|gif)$/,
                use: [
                    {
                        loader: "url-loader",
                        options: {
                            limit: 10000
                        }
                    },
                    {
                        loader: "file-loader",
                        options: {
                            name: "../img/[name].[ext]",
                            publicPath: "./"
                        }
                    }
                ]
            },
            {
                test: /\.sass$/,
                use: ExtractTextPlugin.extract({
                    use: ["css-loader?sourceMap=true", "sass-loader?sourceMap=true"]
                }),
            },
        ]
    },
    plugins: [
        new ExtractTextPlugin({
            filename: "bundle.css",
            allChunks: true
        }),
        new CopyWebpackPlugin([{
            from: SRC_DIR + '/assets/img/icons',
            to: TOMCAT_DIR + '/../img/icons'
        }]),
        new CopyWebpackPlugin([{
            from: SRC_DIR + '/assets/favicon.ico',
            to: TOMCAT_DIR + '/../'
        }])
    ]
}

module.exports = styleConfig;