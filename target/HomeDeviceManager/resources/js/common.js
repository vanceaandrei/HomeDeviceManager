function setCookie(cname, cvalue, expMin) {
    var d = new Date();
    d.setTime(d.getTime() + (expMin * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function reddirectIfLoggedIn() {
    if (userLoggedIn()) {
        $(location).prop("href", "./profile");
    }
}

function logOut() {
    document.cookie = "Username=;";
    document.cookie = "SessionId=;";
}

function userLoggedIn() {
    var user = getCookie("Username");
    var session = getCookie("SessionId");
    if (session != "" && session != null && user != "" && user != null) {
        //user is already logged in
        return true;
    } else {
        return false;
    }
}

function redirectIfNotLoggedIn(){
    if (!userLoggedIn()) {
        $(location).prop("href", "/HomeDeviceManager/login");
    }
}