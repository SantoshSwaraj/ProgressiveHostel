<%-- 
    Document   : SetClassSection
    Created on : 19 Apr, 2018, 5:43:00 PM
    Author     : Santosh Kushwaha
--%>

<%@page import="Section.Bean.SectionBean"%>
<%@page import="Section.DAO.SectionDAOImpl"%>
<%@page import="Section.DAO.SectionDAO"%>
<%@page import="Classes.Bean.ClassBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.DAO.ClassDAOImpl"%>
<%@page import="Classes.DAO.ClassDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us">	
    <head>
        <meta charset="utf-8">
        <title>Set Class-Section | Progressive Hostel</title>
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
        <script src="setClassSection.js"></script>
    </head>
    <body class="smart-style-0" onload="hideMsg();">
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
                <!--ADD CLASS START -->
                <div class="container-fluid">
                    <header class="MainHeader">
                        <span class="widget-icon"> <i style="display:inline" class="fa fa-edit"></i><h2 style="display:inline"> Add Class Wise Section</h2> </span>
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
                            <form action="/ProgressiveHostel/AddClassSection" method="POST" id="AddClassSection" class="smart-form"> 
                                <fieldset>
                                    <div class="row">
                                        <section class="col col-6">
                                            <label class="select">
                                                <select name="CLASS_ID" id="CLASS_ID">
                                                    <option value="0" selected="" disabled="">Select Class</option>
                                                    <%                                                        ClassDAO classDAO = new ClassDAOImpl();
                                                        ArrayList<ClassBean> classBeanList = classDAO.getClasses();
                                                        for (ClassBean classBean : classBeanList) {

                                                    %>
                                                    <option value="<%=classBean.getCLASS_ID()%>"><%=classBean.getCLASS_NAME()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select> <i></i> </label>
                                        </section>
                                        <section class="col col-6">
                                            <label class="select">
                                                <select name="SECTION_ID" id="SECTION_ID" onchange="checkClassSectionAvailablity()">
                                                    <option value="0" selected="" disabled="">Select Section</option>
                                                    <%
                                                        SectionDAO sectionDAO = new SectionDAOImpl();
                                                        ArrayList<SectionBean> sectionBeanList = sectionDAO.getSections();
                                                        for (SectionBean sectionBean : sectionBeanList) {
                                                    %>
                                                    <option value="<%=sectionBean.getSECTION_ID()%>"><%=sectionBean.getSECTION_NAME()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select> <i></i> </label>
                                        </section>
                                        <span id="checkClassSectionAvailMsg" style="color:red; padding-left: 16px;">Section Already Exist</span>
                                    </div>                               
                                </fieldset>
                                <footer>
                                    <button type="submit" class="btn btn-primary" id="btn">
                                        Submit
                                    </button>
                                </footer>
                            </form>

                        </div>
                        <!-- end widget content -->
                    </div>
                    <!-- end widget div -->
                </div>
                <!--ADD CLASS ENDS 
                <!--VIEW CLASS STARTS-->
                <div class="container-fluid">
                    <header class="MainHeader">
                        <span class="widget-icon"> <i style="display:inline" class="fa fa-table"></i><h2 style="display:inline"> View Class Wise Sections</h2> </span>
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

                            <table id="datatable_tabletools" class="table table-striped table-bordered table-hover" width="100%">
                                <thead>
                                    <tr>
                                        <th data-hide="phone">Class ID</th>
                                        <th data-class="expand">Section Name</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>A</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>B</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>C</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>D</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- end widget content -->
                    </div>
                    <!-- end widget div -->
                </div>
                <!-- end widget -->
                <!--VIEW CLASS ENDS-->
            </div>
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


