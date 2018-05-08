<%-- 
    Document   : HostelMonthlyFeeForm
    Created on : 24 Apr, 2018, 4:19:13 PM
    Author     : SantoshKushwaha
--%>
<%@page import="Month.Bean.MonthBean"%>
<%@page import="Month.DAO.MonthDAOImpl"%>
<%@page import="Month.DAO.MonthDAO"%>
<%@page import="Section.Bean.SectionBean"%>
<%@page import="Section.DAO.SectionDAOImpl"%>
<%@page import="Section.DAO.SectionDAO"%>
<%@page import="Classes.DAO.ClassDAOImpl"%>
<%@page import="Classes.DAO.ClassDAO"%>
<%@page import="Classes.Bean.ClassBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    if (session.getAttribute("USER_ID") != null) {
%> 
<!DOCTYPE html>
<html lang="en-us">	
    <head>
        <meta charset="utf-8">
        <title>Hostel Monthly Fee Form | Progressive Hostel</title>
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
            .MainHeader{
                padding-bottom: 21px;
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
                <!--Hostel Monthly Fee Form Starts-->
                <div class="container-fluid">
                    <header class="MainHeader">
                        <span class="widget-icon"> <i style="display:inline" class="fa fa-edit"></i><h2 style="display:inline">Monthly Fee Form</h2></span>
                        <div class="container" id="messageContainer" style="margin-left: -32px;">
                            <div class="row">
                                <div class="col-md-3">
                                    <%@include file="/IncludeFile/message.jsp"%> 
                                </div>
                            </div>
                        </div>
                    </header>
                    <!-- widget div-->
                    <div>
                        <!-- widget edit box -->
                        <div class="jarviswidget-editbox">
                            <!-- This area used as dropdown edit box -->
                        </div>
                        <!-- end widget edit box -->

                        <!-- widget content -->
                        <div class="widget-body no-padding">
                            <form action="/ProgressiveHostel/SearchStudentMonthlyFeeLedger" method="POST" id="addClass-form" class="smart-form">
                                <fieldset>
                                    <div class="row">
                                        <section class="col col-md-4">
                                            <label class="input"> <i class="icon-append fa fa-institution"></i>
                                                <input type="text" name="ADMISSION_NO_OR_STUDENT_ID" id="ADMISSION_NO_OR_STUDENT_ID" placeholder="Admission No or Student ID">
                                                <span id="" style="color:red;"></span>
                                            </label>
                                        </section>
                                        <section class="col col-4">
                                            <label class="select">
                                                <select name="BILL_MONTH_ID" id="BILL_MONTH_ID">
                                                    <option value="0" selected="" disabled="">Select Month</option>
                                                    <%
                                                        MonthDAO monthDAO = new MonthDAOImpl();
                                                        ArrayList<MonthBean> monthBeanList = monthDAO.getMonths();
                                                        for (MonthBean monthBean : monthBeanList) {
                                                    %>
                                                    <option value="<%=monthBean.getMONTH_ID()%>"><%=monthBean.getMONTH()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select> <i></i> </label>
                                        </section>
                                        <section class="col col-4">
                                            <label class="select">
                                                <select name="BILL_YEAR" id="BILL_YEAR">
                                                    <option value="0" selected="" disabled="">Select Year</option>
                                                    <option value="2018">2018</option>
                                                    <option value="2019">2019</option>
                                                    <option value="2020">2020</option>
                                                    <option value="2021">2021</option>
                                                </select> <i></i> </label>
                                        </section>
                                    </div>   
                                </fieldset>

                                <footer>
                                    <button type="submit" class="btn btn-primary" id="btn"> 
                                        Search
                                    </button>
                                </footer>
                            </form>
                        </div>
                        <!-- end widget content -->
                    </div>
                    <!-- end widget div -->
                </div>

                <!--Hostel Monthly Fee Form Ends  -->
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
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>
