<html>
<head>
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
    <script src="resources/js/profile.js"></script>
</head>
<body class="head">
<div ng-app="myApp" ng-controller="myCtrl" >
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
                        <li><a href="{{href1}}" id="LoginButton">{{button1}}</a></li>
                        <li><a href="{{href2}}" id="RegisterButton" ng-click="logout()">{{button2}}</a></li>
                        {{anotherButtons}}
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid main-container" ng-controller="pCtrl">
            <div class="row">
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <h1>Your devices</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                    <div class="list-group">
                        <div class="list-group-item" ng-repeat="d in devices">
                            <h4 class="list-group-item-heading"><a href="#">{{d.name}}</a></h4>
                            <p class="list-group-item-text" style="color: black;">{{d.description}}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>