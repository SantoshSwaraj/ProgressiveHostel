<%-- 
    Document   : login.jsp
    Created on : Apr 18, 2018, 8:47:23 PM
    Author     : SantoshKushwaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us" id="extr-page">
    <head>
        <meta charset="utf-8">
        <title>Progressive Hostel | Login</title>
        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/font-awesome.min.css">

        <!-- Caution! DO NOT change the order -->
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/smartadmin-production-plugins.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/smartadmin-production.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/smartadmin-skins.min.css">

        <!-- RTL Support -->
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/smartadmin-rtl.min.css"> 
        <link rel="stylesheet" type="text/css" media="screen" href="assets/css/demo.min.css">

        <!-- #FAVICONS -->
        <link rel="shortcut icon" href="assets/img/favicon/favicon.ico" type="image/x-icon">
        <link rel="icon" href="assets/img/favicon/favicon.ico" type="image/x-icon">

        <!-- #GOOGLE FONT -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">
    </head>
    <body class="animated fadeInDown">
        <header id="header">
            <div id="logo-group">
                <span id="logo"> 
                    <img src="assets/img/logo.png" alt="Progressive Hostel">  
                </span>
            </div>
            <span id="extr-page-header-space"> <span class="hidden-mobile hidden-xs">Need an account?</span> <a href="register.jsp" class="btn btn-danger">Create account</a> </span>
        </header>
        <div id="main" role="main">
            <!-- MAIN CONTENT -->
            <div id="content" class="container">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
                        <h1 class="txt-color-red login-header-big">Progressive Hostel</h1>
                        <div class="hero">
                            <div class="pull-left login-desc-box-l">
                                <h4 class="paragraph-header">
                                    Patna Ranchi Road, Jhumri Telaiya<br/>
                                    Koderma, Jharkhand (Pin - 825409)<br/>
                                    Phone no : 9999999999
                                </h4>
                            </div>
                            <img src="/img/demo/iphoneview.png" class="pull-right display-image" alt="" style="width:210px">
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                <h5 class="about-heading">About Progressive Hostel - Are you up to date?</h5>
                                <p>
                                    Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa.
                                </p>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                <h5 class="about-heading">Other Details</h5>
                                <p>
                                    Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi voluptatem accusantium!
                                </p>
                            </div>
                        </div>
                    </div>

                    <!-- Message -->
                    <%
                        try {
                            if (session.getAttribute("wmsg") == null || session.getAttribute("wmsg") == " " || session.getAttribute("wmsg").toString().equals("")) {
                    %> 
                    <div id="wmsg">
                        <%session.setAttribute("wmsg", " ");%>  
                    </div> 
                    <%
                    } else {%> 
                    <div id="wmsg" style="color: black; font-size: 13px; font-weight: 900; background-color: #ff000063; padding: 8px; margin-left: 786px; margin-right: 13px; margin-bottom: 12px;">
                        <strong>
                            Error ! <%=session.getAttribute("wmsg")%>
                        </strong>
                        <%session.setAttribute("wmsg", " ");%> 
                    </div> 
                    <%}
                        } catch (Exception e) {

                        }
                    %> 

                    <%
                        try {
                            if (session.getAttribute("msg") == null || session.getAttribute("msg") == " " || session.getAttribute("msg").toString().equals("")) {
                    %> 
                    <div id="msg">
                        <%session.setAttribute("msg", " ");%> 
                    </div> 
                    <%
                    } else {%> 
                    <div id="msg" style="color: black; font-size: 13px; font-weight: 900; background-color: #a6f3b3; padding: 8px; margin-left: 786px; margin-right: 13px; margin-bottom: 12px;">
                        <strong>
                            Success ! <%=session.getAttribute("msg")%>
                        </strong>
                        <%session.setAttribute("msg", " ");%> 
                    </div> 
                    <%}
                        } catch (Exception e) {

                        }
                    %> 
                    <!-- Message -->


                    <div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
                        <div class="well no-padding">
                            <form action="/ProgressiveHostel/Login" method="post" id="login-form" class="smart-form client-form">
                                <header>
                                    Sign In 
                                </header>
                                <fieldset>
                                    <section>
                                        <label class="label">Username</label>
                                        <label class="input"> <i class="icon-append fa fa-user"></i>
                                            <input type="text" name="USERNAME" id="USERNAME" minlength="5" maxlength="35" required="">
                                            <b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> Please enter username</b></label>
                                    </section>
                                    <section>
                                        <label class="label">Password</label>
                                        <label class="input"> <i class="icon-append fa fa-lock"></i>
                                            <input type="password" name="PASSWORD" id="PASSWORD" minlength="5" maxlength="35" required="">
                                            <b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> Enter your password</b> </label>
                                        <div class="note">
                                            <a href="forgotpassword.jsp">Forgot password?</a>
                                        </div>
                                    </section>
                                </fieldset>
                                <footer>
                                    <button type="submit" class="btn btn-primary">
                                        Sign in
                                    </button>
                                </footer>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/IncludeFile/footer.jsp"%>
        <!--================================================== -->
        <script src="/ProgressiveHostel/assets/js/libs/jquery-3.2.1.min.js"></script>
        <script src="/ProgressiveHostel/assets/js/libs/jquery.min.js"></script>
        <script src="/ProgressiveHostel/assets/js/libs/jquery-ui.min.js"></script>
    </body>
</html>
