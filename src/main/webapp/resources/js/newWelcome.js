var app = angular.module("myApp", []);
var usercookie = getCookie("username");
app.controller("myCtrl", function ($scope) {
    if (usercookie === "") {
        $scope.href1 = "login";
        $scope.href2 = "register";
        $scope.button1 = "Login";
        $scope.button2 = "Register";
    } else {
        $scope.href1 = "profile";
        $scope.href2 = "logout";
        $scope.button1 = "Profile";
        $scope.button2 = "Logout";
    }
});
