<%@ page import="util.Const" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loggedIn" value="false"/>
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (Const.SESSION_COOKIE.equals(cookie.getName()) && cookie.getValue().length() > 1) {
            pageContext.setAttribute("loggedIn", true);
        } else if (Const.SESSION_COOKIE.equals(cookie.getName())) {
            pageContext.setAttribute("loggedIn", false);
        }
    }
%>
<html>
<head>
    <title>HomeDeviceManager</title>
    <script src="<c:url value="/resources/js/jquery-3.1.0.min.js"/>"></script>
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
    <script src="<c:url value="/resources/js/common.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<div class="jumbotron noPadding noMargins">
    <img class="backgroundImage" src="<c:url value="/resources/images/background.jpg"/>">
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
                    <li><a href="<c:url value="/"/>">Home<span class="sr-only">(current)</span></a></li>
                    <li><a href="<c:url value="/"/>">About</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${loggedIn == false}">
                        <li><a href="<c:url value="/login" />" id=" LoginButton">Login</a></li>
                        <li><a href="<c:url value="/register"/>" id="RegisterButton">Register</a></li>
                    </c:if>
                    <c:if test="${loggedIn == true}">
                        <li><a href="<c:url value="/profile" />"> Profile </a></li>
                        <li><a href="<c:url value="/myDevices"/> ">My Devices</a></li>
                        <li><a href="<c:url value="/"/>" id="LogOutButton" onclick="logOut()">Log Out</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container-fluid noPadding">
        <div class="descriptionBox topDiv">
            <div>
                <h1>Welcome to HomeDeviceManager console </h1>
            </div>
            <div>
                <p>Here you will find a easy manager console to
                    manage your inner systems by registering them to the console. You can control all devices
                    and get information about them on your LAN network.</p>
            </div>
        </div>

        <div class="descriptionBox welcome2Box">
            <div class="row">
                <a href="#">
                    <div class="smallContentBox flex-container col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <div class="flex-item">Tutorials</div>
                    </div>
                </a>
                <a href="#">
                    <div class="smallContentBox flex-container col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <div class="flex-item">User Guide</div>
                    </div>
                </a>
                <a href="#">
                    <div class="smallContentBox flex-container col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <div class="flex-item">All about IOT</div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>