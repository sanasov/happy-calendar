export default class HpCtrl {

    constructor($scope) {
        angular.extend($scope, {
            ctrl: this,
        });
        this.$scope = $scope;
        $scope.firstName = "John";
        $scope.lastName = "Doe";
    }


}

HpCtrl.$inject = [
    '$scope'
];