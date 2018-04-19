<%-- 
    Document   : AdminDashboard
    Created on : Apr 18, 2018, 10:41:29 PM
    Author     : SantoshKushwaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us">	
    <head>
        <meta charset="utf-8">
        <title>Admin Dashboard | Progressive Hostel</title>
        <meta name="description" content="">
        <meta name="author" content="">

        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/font-awesome.min.css">

        <!-- Caution! DO NOT change the order -->
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/smartadmin-production-plugins.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/smartadmin-production.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/smartadmin-skins.min.css">

        <!-- RTL Support -->
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/smartadmin-rtl.min.css"> 
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/demo.min.css">

        <!-- #FAVICONS -->
        <link rel="shortcut icon" href="/ProgressiveHostel/assets/img/favicon/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/ProgressiveHostel/assets/img/favicon/favicon.ico" type="image/x-icon"> 
        <!-- #GOOGLE FONT -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">
        <style>
            #demo-setting{
                display: none;
            }
        </style>
    </head>
    <body class="smart-style-0">
        <%@include file="/IncludeFile/header.jsp"%>
        <%@include file="/IncludeFile/aside.jsp"%>
        <!-- #MAIN PANEL -->
        <div id="main" role="main">

            <!-- RIBBON -->
            <div id="ribbon">

                <span class="ribbon-button-alignment"> 
                    <span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh" rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true" data-reset-msg="Would you like to RESET all your saved widgets and clear LocalStorage?"><i class="fa fa-refresh"></i></span> 
                </span>
            </div>
            <!-- END RIBBON -->

            <!-- #MAIN CONTENT -->
            <div id="content">

            </div>

            <!-- END #MAIN CONTENT -->
        </div>
        <!-- END #MAIN PANEL -->
        <%@include file="/IncludeFile/mainfooter.jsp"%>
 
        <div id="shortcut">
            <ul>
                <li>
                    <a href="#ajax/inbox.html" class="jarvismetro-tile big-cubes bg-color-blue"> <span class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail <span class="label pull-right bg-color-darken">14</span></span> </span> </a>
                </li>
                <li>
                    <a href="#ajax/calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span> </span> </a>
                </li>
                <li>
                    <a href="#ajax/gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple"> <span class="iconbox"> <i class="fa fa-map-marker fa-4x"></i> <span>Maps</span> </span> </a>
                </li>
                <li>
                    <a href="#ajax/invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark"> <span class="iconbox"> <i class="fa fa-book fa-4x"></i> <span>Invoice <span class="label pull-right bg-color-darken">99</span></span> </span> </a>
                </li>
                <li>
                    <a href="#ajax/gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight"> <span class="iconbox"> <i class="fa fa-picture-o fa-4x"></i> <span>Gallery </span> </span> </a>
                </li>
                <li>
                    <a href="#ajax/profile.html" class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My Profile </span> </span> </a>
                </li>
            </ul>
        </div>
        <!-- END SHORTCUT AREA -->
        <script src="/ProgressiveHostel/assets/js/libs/jquery.min.js"></script> 
        <script src="/ProgressiveHostel/assets/js/libs/jquery-ui.min.js"></script>
        <!--================================================== -->
        <!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
        
        <script src="/ProgressiveHostel/assets/js/dropdown.js"></script> 
        <script src="/ProgressiveHostel/assets/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> 

        <!-- BOOTSTRAP JS -->
        <script src="/ProgressiveHostel/assets/js/bootstrap/bootstrap.min.js"></script>

        <!-- CUSTOM NOTIFICATION -->
        <script src="/ProgressiveHostel/assets/js/notification/SmartNotification.min.js"></script>

        <!-- JARVIS WIDGETS -->
        <script src="/ProgressiveHostel/assets/js/smartwidgets/jarvis.widget.min.js"></script>

        <!-- EASY PIE CHARTS -->
        <script src="/ProgressiveHostel/assets/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

        <!-- SPARKLINES -->
        <script src="/ProgressiveHostel/assets/js/plugin/sparkline/jquery.sparkline.min.js"></script>

        <!-- JQUERY VALIDATE -->
        <script src="/ProgressiveHostel/assets/js/plugin/jquery-validate/jquery.validate.min.js"></script>

        <!-- JQUERY MASKED INPUT -->
        <script src="/ProgressiveHostel/assets/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

        <!-- JQUERY SELECT2 INPUT -->
        <script src="/ProgressiveHostel/assets/js/plugin/select2/select2.min.js"></script>

        <!-- JQUERY UI + Bootstrap Slider -->
        <script src="/ProgressiveHostel/assets/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

        <!-- browser msie issue fix -->
        <script src="/ProgressiveHostel/assets/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

        <!-- FastClick: For mobile devices: you can disable this in app.js -->
        <script src="/ProgressiveHostel/assets/js/plugin/fastclick/fastclick.min.js"></script>

        <!--[if IE 8]>
                <h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
        <![endif]-->

        <!-- Demo purpose only -->
        <script src="/ProgressiveHostel/assets/js/demo.min.js"></script>
        <!-- SmartChat UI : plugin -->
        <script src="/ProgressiveHostel/assets/js/smart-chat-ui/smart.chat.ui.min.js"></script>
        <script src="/ProgressiveHostel/assets/js/smart-chat-ui/smart.chat.manager.min.js"></script>
    </body>
</html>
