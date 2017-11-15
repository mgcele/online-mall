var OnlineMallApp = angular.module("OnlineMallApp", [
    "ui.router",
    "ngResource",
    "ui.bootstrap"
]);

OnlineMallApp.controller('onlineMallRootController', ['$rootScope', function ($rootScope) {
    console.log("app test successful!");
}]);

// OnlineMallApp.controller(function ($rootScope) {
//     console.log("Test successful!");
// });