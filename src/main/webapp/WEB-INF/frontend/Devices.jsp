<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Devices</title>
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
<body class="head">
<div class="jumbotron" style="background-image: <c:url value="/resources/images/background.jpg"/>">
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
    <div class="container-fluid">

    </div>
</div>
</body>
</html>
