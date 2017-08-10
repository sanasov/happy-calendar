
import angular from "angular";
import runConfig from "./config/runConfig.js";
import templateRepository from "./common/templateRepository.js";
import HpCtrl from "./controller/HpCtrl.js";

const app = angular.module('App', [])
    .run(runConfig)
    .service("templateRepository", templateRepository)
    .controller("HpCtrl", HpCtrl);