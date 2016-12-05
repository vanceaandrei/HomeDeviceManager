$(document).ready(function () {

    reddirectIfLoggedIn();

    var loginForm = $('#loginForm');

    loginForm.submit(function (e) {

        var username = $('input[name=username]', loginForm).val();
        var p = $('input[name=password]', loginForm).val();

        var request = {"username": username, "password": p};

        $.ajax({
            type: 'POST',
            url: '/HomeDeviceManager/login',
            dataType: 'json',
            data: JSON.stringify(request),
            contentType: "application/json",
            success: function (data) {
                if (data.status === "200") {
                    var json = JSON.parse(JSON.stringify(data));
                    setCookie("SessionId", json["SessionId"], 15);
                    setCookie("email", json["email"], 15);
                    $(location).prop("href", "./profile");
                } else {
                    alert(data.message);
                }
            },
            error: function () {
                alert("ERROR");
            }
        });
        e.preventDefault();
        return false;
    });
});