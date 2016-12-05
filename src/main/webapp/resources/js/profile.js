$(document).ready(function () {
    redirectIfNotLoggedIn();
});
var user = getCookie("email");
console.log(user);
var request = user;
var d;
app.controller('pCtrl', function($scope, $http) {
    var req = {
        method: 'POST',
        url: '/HomeDeviceManager/profile/loadDevices',
        data: request,
        dataType: 'json',
        contentType: "application/json"
    }
    $http(req).then(function (data) {
        console.log("success");
        if (data.status === 200) {
            console.log("success");
            d = JSON.parse(data.data.devices);
            $scope.devices = d;
        } else {
            alert(data.message);
        }}, function () {
        console.log("ajax error"); });
});