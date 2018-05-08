<%-- 
    Document   : forgotpassword
    Created on : 1 May, 2018, 10:03:05 AM
    Author     : Santosh Kushwaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us" id="extr-page">
    <head>
        <meta charset="utf-8">
        <title>Progressive Hostel | Forget Password</title>
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
        <!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
        <header id="header">
            <!--<span id="logo"></span>-->

            <div id="logo-group">
                <img src="assets/img/logo.png" alt="Progressive Hostel">  
                <!-- END AJAX-DROPDOWN -->
            </div>
            <span id="extr-page-header-space"> <span class="hidden-mobile hidden-xs">Need an account?</span> <a href="register.html" class="btn btn-danger">Create account</a> </span>
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
                    <div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
                        <div class="well no-padding">
                            <form action="/ProgressiveHostel/ForgotPassword" method="post" id="forgotpassword-form" class="smart-form client-form">
                                <header>
                                    Forgot Password
                                </header>
                                <fieldset>
                                    <section>
                                        <label class="label">Enter your email address or mobile no</label>
                                        <label class="input"> <i class="icon-append fa fa-envelope"></i>
                                            <input type="text" name="EMAIL_MOBILE" id="EMAIL_MOBILE">
                                            <b class="tooltip tooltip-top-right"><i class="fa fa-envelope txt-color-teal"></i>Please enter email address or mobile no for password reset</b></label>
                                    </section>
                                    <div class="note">
                                        <a href="index.jsp">I remembered my password!</a>
                                    </div>
                                </fieldset>
                                <footer>
                                    <button type="submit" class="btn btn-primary">
                                        <i class="fa fa-refresh"></i> Reset Password
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
    </body>
</html>
