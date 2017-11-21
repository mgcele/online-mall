OnlineMallApp.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state("index", {
        url : "/index",
        templateUrl : templatePath + "login/index.html"
    });

    $urlRouterProvider.otherwise('/index');
});

OnlineMallApp.controller('loginController', ['$scope', function ($scope) {
    console.log("login test successful!");
}]);