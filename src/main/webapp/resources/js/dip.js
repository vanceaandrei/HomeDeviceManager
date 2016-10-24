$(document).ready(function () {

    redirectIfNotLoggedIn();

    var uploadForm = $('#uploadForm');

    uploadForm.submit(function (e) {

        e.preventDefault();

        var formData = new FormData();

        //var command = $('#command').val();

        formData.append('file', $('#fileInput')[0].files[0]);
        //formData.append('command', command);

        $.ajax({
            type: 'POST',
            url: '/HomeDeviceManager/modules/dip',
            data: formData,
            enctype: 'multipart/form-data',
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                if (data.status === "200") {
                    var json = JSON.parse(JSON.stringify(data));
                    $('#imageDiv').html('<img src="data:image/jpg;base64,' + json['file'] + '" style="max-width: 512px; max-height: 512px"/>');
                } else {
                    alert(data.message);
                }
            },
            error: function () {
                alert("ERROR");
            }
        });
        return false;
    });
});

function sendCommand(commandButton, value) {

    $('#brightnessRange').html($('#brightnessRangeBar').val());
    $('#contrastRange').html($('#contrastRangeBar').val());

    var formData = new FormData();

    var command = commandButton;

    formData.append('file', $('#fileInput')[0].files[0]);
    formData.append('command', command);
    formData.append('brightness', value);

    $.ajax({
        type: 'POST',
        url: '/HomeDeviceManager/modules/dip/command',
        data: formData,
        enctype: 'multipart/form-data',
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data.status === "200") {
                var json = JSON.parse(JSON.stringify(data));
                $('#imageDiv').html('<img src="data:image/jpg;base64,' + json['file'] + '" style="max-width: 512px; max-height: 512px"/>');
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
