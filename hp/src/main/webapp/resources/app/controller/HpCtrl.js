export default class HpCtrl {

    constructor($scope, $http, servlet, toastr, $timeout, $interval) {
        angular.extend($scope, {
            ctrl: this,
            $timeout,
            toastr,
            $http,
            servlet,
            $interval
        });
        this.$scope = $scope;
        $scope.firstName = "John";
        $scope.lastName = "Doe";
    }


}

HpCtrl.$inject = [
    '$scope',
    '$http',
    'servlet',
    'toastr',
    '$timeout',
    '$interval'
];