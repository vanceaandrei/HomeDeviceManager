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
    <script src="<c:url value="/resources/js/dip.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<div class="jumbotron noPadding noMargins">
    <img class="backgroundImage" src="<c:url value="/resources/images/IoT.jpg"/>">
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
                        <li><a href="<c:url value="/"/>" id="LogOutButton" onclick="logOut()">Log Out</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container-fluid noPadding topDiv">
        <div class="row">
            <div class="defaultDiv right col-xs-3 col-sm-3 col-md-3 col-lg-3" id="submitPictureDiv">
                <form class="form-horizontal" id="uploadForm" method="POST" enctype="multipart/form-data">
                    <label class="control-label">Select File</label>
                    <input type="file" class="file-loading" name="file" id="fileInput" onchange="showPicture(this)">
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                <div class="defaultDiv imageDiv">
                    <div id="imageDiv"
                         style="width: 512px; height: 512px; ">
                    </div>
                </div>
            </div>
            <div class="defaultDiv right col-xs-7 col-sm-7 col-md-7 col-lg-7" id="commandPanel">
                <div class="row">
                    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                        <button class="button" id="blackAndWhite" name="commandButton" value="greyScale"
                                onclick="sendCommand(this.value, 0)">
                            B & W
                        </button>
                    </div>
                    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                        <button class="button" id="red" name="commandButton" value="YIQ"
                                onclick="sendCommand(this.value, 0)">
                            YIQ
                        </button>
                    </div>
                    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                        <button class="button" id="green" name="commandButton" value="YCBCR"
                                onclick="sendCommand(this.value, 0)">
                            YCbCr
                        </button>
                    </div>
                    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                        <button class="button" id="blue" name="commandButton" value="HSV" disabled
                                onclick="sendCommand(this.value, 0)">
                            HSV
                        </button>
                    </div>
                </div>
                <div class="row">
                    <label class="control-label">Brightness</label>
                    <input type="range" min="-255" max="255" value="0" id="brightnessRangeBar" name="rangeBar"
                           onmouseup="sendCommand('BRIGHTNESS', this.value)">
                    <span id="brightnessRange">0</span>
                </div>
                <div class="row">
                    <label class="control-label">Contrast</label>
                    <input type="range" min="0" max="255" value="0" id="contrastRangeBar" name="rangeBar"
                           onmouseup="sendCommand('CONTRAST', this.value)">
                    <span id="contrastRange">0</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>