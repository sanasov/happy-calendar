const webpack = require('webpack');
const path = require('path');

const SRC_DIR = path.resolve(__dirname, 'src/main/client');
const DEST_DIR = path.resolve(__dirname, 'src/main/webapp/resources/app');
const NODE_MODULE_ROOT = path.resolve(__dirname, 'node_modules');

function isExternal(module) {
    if (!module.userRequest) {
        return false;
    }
    return module.userRequest.indexOf('node_modules') >= 0;
}

module.exports = {

    devtool: 'cheap-module-eval-source-map', // for view src in browser
    watch: false,
    context: SRC_DIR,
    entry: {
        app: './main.ts'
    },
    resolve: {
        modules: [
            SRC_DIR,
            NODE_MODULE_ROOT
        ],
        extensions: ['.tsx', '.ts', '.js', '.json']
    },
    output: {
        path: DEST_DIR,
        filename: 'bundle.js',
        publicPath: '/app/'
    },
    module: {
        // rules: [
        //     {
        //         test: /\.ts$/,
        //         use: [
        //             'awesome-typescript-loader',
        //             'angular2-template-loader'
        //         ]
        //     },
        //     {
        //         test: /\.html$/,
        //         exclude: /node_modules/,
        //         use: 'html-loader'
        //     }
        // ],
        loaders: [
            // {
            //     test: /\.ts$/,
            //     exclude: /node_modules/,
            //     options: {configFileName: helpers.root('src', 'tsconfig.json')},
            //     use: 'awesome-typescript-loader'
            // }, {
            //     test: /\.ts$/,
            //     exclude: /node_modules/,
            //     use: 'angular2-template-loader'
            // },
            // {
            //     test: /\.html$/,
            //     exclude: /node_modules/,
            //     use: 'html-loader'
            // }
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
            }
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