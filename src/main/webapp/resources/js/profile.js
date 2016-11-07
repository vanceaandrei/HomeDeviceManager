$(document).ready(function () {
    redirectIfNotLoggedIn();

    showProfilePicture();
});

function savePicture() {
    redirectIfNotLoggedIn();
    var formData = new FormData();

    formData.append('file', $('#fileInput')[0].files[0]);

    showPicture($('#fileInput'));

    $.ajax({
        type: 'POST',
        url: '/HomeDeviceManager/profile/upload',
        data: formData,
        enctype: 'multipart/form-data',
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data.status === "200") {
                var json = JSON.parse(JSON.stringify(data));
                $('#imageDiv').html('<img src=""/>');
            } else {
                alert(data.message);
            }
        },
        error: function () {
            alert("ERROR");
        }
    });
}

function showPicture(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imageDiv').html('<img src="' + e.target.result + '" style="max-width: 512px; max-height: 512px"/>');
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function showProfilePicture() {

    var emailCookie = getCookie("email");

    $.ajax({
        type: 'GET',
        url: '/HomeDeviceManager/profile/getProfilePicture',
        data: emailCookie,
        success: function (data) {
            if (data.status === "200") {
                var json = JSON.parse(JSON.stringify(data));
                $('#imageDiv').html('<img src=""/>');
            } else {
                //silent -> no profile picture
            }
        },
        error: function () {
            console.error("ajax call failed");
        }
    });
}