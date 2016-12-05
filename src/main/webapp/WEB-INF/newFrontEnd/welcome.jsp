<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HomeDeviceManager</title>
    <script src="resources/js/jquery-3.1.0.min.js"></script>
    <script src="resources/js/angular.min.js"></script>
    <script src="resources/js/common.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <!--<script src="/resources/js/common.js"></script>-->
    <link rel="stylesheet" href="resources/css/style.css">

</head>
<body class="head">
<div ng-app="myApp" ng-controller="myCtrl">
    <div class="jumbotron noPadding">
        <img class="backgroundImage" src="resources/images/background.jpg">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Home Device Manager</a>
                </div>

                <div class="collapse navbar-collapse" id="navbar">
                    <ul class="nav navbar-nav">
                        <li><a href="/HomeDeviceManager">Home<span class="sr-only">(current)</span></a></li>
                        <li><a href="/HomeDeviceManager">About</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="{{href1}}" id="LoginButton">{{button1}}</a></li>
                        <li><a href="{{href2}}" id="RegisterButton">{{button2}}</a></li>
                        {{anotherButtons}}
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container-fluid main-container">
            <div class="row">
                <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>

                <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 descriptionBox">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ornare, eros non varius finibus,
                        ipsum magna fringilla velit, et varius est purus eget nunc.
                        Cras pharetra facilisis nibh, ut iaculis purus mollis id. Sed elit purus, aliquam vitae eleifend
                        a,
                        porta vitae lectus. </p>
                    <p>In imperdiet purus efficitur mauris elementum tempus. Morbi auctor mauris ut faucibus varius.
                        Proin
                        fringilla velit tellus, id tincidunt erat viverra eu.</p>
                    Quisque erat lorem, condimentum et urna at, eleifend egestas urna. Integer placerat, erat at
                    ultrices vulputate, nibh tellus sollicitudin erat, id lobortis massa elit a magna.
                    Nullam gravida velit at condimentum dictum. Aliquam ac turpis eget urna suscipit finibus eu
                    vestibulum mauris. Quisque cursus magna nunc, sed ultricies massa sollicitudin quis.
                    Sed sodales mi eu elit luctus dictum. Donec cursus arcu sed quam commodo posuere sit amet id nunc.
                    Pellentesque vehicula ligula ut lacus auctor, sit amet aliquet eros tempus.
                    Nullam interdum efficitur magna, eu blandit nibh faucibus quis. Pellentesque erat felis, faucibus
                    vel aliquet sed, euismod at nibh.
                </div>

                <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
            </div>
            <div class="row">
                <img class="backgroundImage noPadding" src="resources/images/widescreen.jpg">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 descriptionBox">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ornare, eros non varius finibus,
                        ipsum magna fringilla velit, et varius est purus eget nunc.
                        Cras pharetra facilisis nibh, ut iaculis purus mollis id. Sed elit purus, aliquam vitae eleifend
                        a,
                        porta vitae lectus. </p>
                    <p>In imperdiet purus efficitur mauris elementum tempus. Morbi auctor mauris ut faucibus varius.
                        Proin
                </div>
            </div>

            <div class="row">
                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 descriptionBox">
                    <video src="resources/videos/welcomeVideo.mp4" autoplay muted></video>
                </div>
                <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1 descriptionBox"></div>
                <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5 descriptionBox">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ornare, eros non varius finibus,
                        ipsum magna fringilla velit, et varius est purus eget nunc.
                        Cras pharetra facilisis nibh, ut iaculis purus mollis id. Sed elit purus, aliquam vitae eleifend
                        a,
                        porta vitae lectus. </p>
                    <p>In imperdiet purus efficitur mauris elementum tempus. Morbi auctor mauris ut faucibus varius.
                        Proin
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>