<%-- 
    Document   : register.jsp
    Created on : 30 Apr, 2018, 5:49:04 PM
    Author     : Santosh Kushwaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us" id="extr-page">
    <head>
        <meta charset="utf-8">
        <title>Progressive Hostel | Registration Form</title>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="utils.js"></script>
    </head>
    <body id="login" onload="hideUsernameValMsgs();
            hideMobileValMsgs();
            hideEmailValMsgs();"> 
        <!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
        <header id="header">
            <!--<span id="logo"></span>-->

            <div id="logo-group">
                <img src="assets/img/logo.png" alt="Progressive Hostel">

                <!-- END AJAX-DROPDOWN -->
            </div>

            <span id="extr-page-header-space"> <span class="hidden-mobile hidden-xs">Already registered?</span> <a href="index.jsp" class="btn btn-danger">Sign In</a> </span>

        </header>

        <div id="main" role="main">

            <!-- MAIN CONTENT -->
            <div id="content" class="container">

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-7 col-lg-7 hidden-xs hidden-sm">
                        <h1 class="txt-color-red login-header-big">Progressive Hostel</h1>
                        <div class="hero">
                            <div class="pull-left login-desc-box-l">
                                <h4 class="paragraph-header">
                                    Patna Ranchi Road, Jhumri Telaiya<br/>
                                    Koderma, Jharkhand (Pin - 825409)<br/>
                                    Phone no : 9999999999
                                </h4>
                            </div>
                            <!--<img src="/img/demo/iphoneview.png" class="pull-right display-image" alt="" style="width:210px">-->
                        </div>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                <h5 class="about-heading">About SmartAdmin - Are you up to date?</h5>
                                <p>
                                    Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa.
                                </p>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                                <h5 class="about-heading">Not just your average template!</h5>
                                <p>
                                    Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi voluptatem accusantium!
                                </p>
                            </div>
                        </div>

                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
                        <div class="well no-padding">

                            <form action="/ProgressiveHostel/AddUser" method="POST" id="smart-form-register" class="smart-form client-form">
                                <header>
                                    User Registration Form
                                </header>

                                <fieldset>
                                    <section>
                                        <label class="input"> <i class="icon-append fa fa-user"></i>
                                            <input type="text" name="USERNAME" id="USERNAME" minlength="5" maxlength="35" required="" placeholder="Username" onchange="checkUserNameAvailablity(this.value)">  
                                            <span id="uservalmsg" style="color:red;">Username not available</span>
                                            <b class="tooltip tooltip-bottom-right">Username must be unique</b> </label>
                                    </section>

                                    <section>
                                        <label class="input"> <i class="icon-append fa fa-envelope"></i>
                                            <input type="email" name="EMAIL" id="EMAIL" minlength="5" maxlength="45" required="" placeholder="Email address" onchange="checkEmailAvailablity(this.value);">
                                       
                                            <span id="emailvalmsg" style="color:red;">email not available</span>
                                            <b class="tooltip tooltip-bottom-right">Email must be unique</b> </label> 
                                    </section>

                                    <section>
                                        <label class="input"> <i class="icon-append fa fa-lock"></i>
                                            <input type="password" name="PASSWORD" id="PASSWORD" minlength="5" maxlength="45" required="" placeholder="Password">
                                            <b class="tooltip tooltip-bottom-right">Don't forget your password</b> </label>
                                    </section>

                                    <section>
                                        <label class="input"> <i class="icon-append fa fa-lock"></i>
                                            <input type="password" name="CONFIRM_PASSWORD" id="CONFIRM_PASSWORD" minlength="5" maxlength="45" required="" placeholder="Confirm password">
                                            <b class="tooltip tooltip-bottom-right">Don't forget your password</b> </label>
                                    </section>
                                </fieldset>

                                <fieldset>
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="input">
                                                <input type="text" name="EMPLOYEE_ID" id="EMPLOYEE_ID" minlength="1" maxlength="8" required="" placeholder="Employee Id">
                                                <b class="tooltip tooltip-bottom-right">Enter your Employee Id</b> </label>
                                            </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="input">
                                                <input type="text" name="EMP_NAME" id="EMP_NAME" minlength="2" maxlength="45" required=""  placeholder="Employee Name">
                                                <b class="tooltip tooltip-bottom-right">Enter your Employee Name</b> </label>
                                            </label>
                                        </section>
                                    </div>

                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="select">
                                                <select name="USER_TYPE_ID"> 
                                                    <option value="0" selected="" disabled="">Select User Type</option>
                                                    <option value="1">Admin</option>
                                                    <option value="2">Warden</option>
                                                    <option value="3">Accounts</option>
                                                </select> <i></i> </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="input">
                                                <input type="text" name="MOBILE_NO" id="MOBILE_NO" placeholder="Mobile No"  minlength="10" maxlength="12" required="" onchange="checkMobileAvailablity(this.value)">
                                                <b class="tooltip tooltip-bottom-right">Mobile no must be unique</b> </label>
                                                <span id="mobilevalmsg" style="color:red;">mobile no not available</span>
                                            </label>
                                        </section>
                                    </div>

                                </fieldset>
                                <footer>
                                    <button type="submit" class="btn btn-primary" id="btn">
                                        Register
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
