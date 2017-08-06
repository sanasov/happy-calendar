
// import runConfig from "./config/runConfig";
import HpCtrl from "./controller/HpCtrl";

const app = angular.module('App', [
    'ngAnimate',
    'ui.select',
    'ngDialog',
    'toastr',
    'nya.bootstrap.select',
    'ngMaterial',
    'ngSanitize',
    'ui.router',
    'ui.grid',
    'ui.grid.cellNav',
    'ui.grid.edit',
    'ui.grid.resizeColumns',
    'ui.grid.pinning',
    'ui.grid.pagination',
    'ui.grid.selection',
    'ui.grid.moveColumns'
]);

app
    // .run(runConfig)
    .controller("HpCtrl", HpCtrl);