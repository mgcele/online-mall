OnlineMallApp.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state("index", {
        url : "/index",
        templateUrl : templatePath + "login/index.html"
    }).state("reister", {
        url : "/register",
        templateUrl : templatePath + "login/register.html"
    });

    $urlRouterProvider.otherwise('/index');
});

OnlineMallApp.controller('loginController', ['$scope', 'restApi', function ($scope, restApi) {

    $scope.registerModule = {};

    $scope.obtainVerification = function () {
        if(!$scope.registerModule.username){
            alert("用户名不能为空！");
            return;
        }
        restApi.getVC({},{
            second : $scope.registerModule.username
        }, function success(result) {
            console.log("success!");
        }, function error(result) {
            console.log("error!");
        });
    }

}]);