<html>
<head>
    <title>HomeDeviceManager</title>
    <script src="resources/js/jquery-3.1.0.min.js"></script>
    <script src="resources/js/angular.min.js"></script>
    <script src="resources/js/common.js"></script>
    <script src="resources/js/login.js"></script>
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
    <div class="jumbotron noPadding noMargins">
        <img class="backgroundImage" src="resources/images/background.jpg">
        <nav class="navbar navbar-inverse navbar-fixed-top noMargins">
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
                        <li><a href="{{href1}}">{{button1}}</a></li>
                        <li><a href="{{href2}}" ng-click="logout()">{{button2}}</a></li>
                        {{anotherButtons}}
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container-fluid noPadding topDiv">

            <div class="formDiv topDiv col-xs-3 col-sm-3 col-md-3 col-lg-3">

                <form class="form-horizontal" id="loginForm" role="form">

                    <label class="control-label" for="username">Username:</label>
                    <input type="text" class="form-control" name="username" id="username" required>

                    <label class="control-label" for="password">Password:</label>
                    <input type="password" class="form-control" name="password" id="password" required>

                    <input type="submit" class="btn btn-default btn-lg btn-block" value="Submit" id="submitRegister">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>