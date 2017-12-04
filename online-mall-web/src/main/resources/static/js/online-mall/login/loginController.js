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

OnlineMallApp.controller('loginController', ['$scope', function ($scope) {
}]);