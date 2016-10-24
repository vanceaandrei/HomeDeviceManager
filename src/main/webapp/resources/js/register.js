function checkPassMatch(input) {

    if (input.value != document.getElementById('password').value) {
        input.setCustomValidity('Password Must be Matching.');
    } else {
        // input is valid -- reset the error message
        input.setCustomValidity('');
    }
}

function validateInput(input) {
    if (!isNaN(parseInt(input.value.substring(0, 1)))) {
        input.setCustomValidity('Value can\'t start with a number.');
    } else if (input.value.length > 100) {
        input.setCustomValidity('Max size is 100!');
    } else {
        input.setCustomValidity('');
    }
}

$(document).ready(function () {

    reddirectIfLoggedIn();

    var registerForm = $('#registerForm');

    registerForm.submit(function (e) {

        var name = $('input[name=name]', registerForm).val();
        var surname = $('input[name=surname]', registerForm).val();
        var email = $('input[name=email]', registerForm).val();
        var username = $('input[name=username]', registerForm).val();
        var p = $('input[name=password]', registerForm).val();

        var request = {"name": name, "surname": surname, "email": email, "username": username, "password": p};

        $.ajax({
            type: 'POST',
            url: '/HomeDeviceManager/register',
            dataType: 'json',
            data: JSON.stringify(request),
            contentType: "application/json",
            success: function (data) {
                    var json = JSON.parse(JSON.stringify(data));
                    setCookie("SessionId", json["SessionId"], 15);
                    setCookie("Username", json["Username"], 15);
                    $(location).prop("href", "./login");
            },
            error: function (data) {
                alert(JSON.stringify(data));
            }
        });
        e.preventDefault();
        return false;
    });
});
