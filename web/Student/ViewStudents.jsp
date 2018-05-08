<%-- 
    Document   : ViewStudents
    Created on : 1 May, 2018, 4:54:32 PM
    Author     : Santosh Kushwaha
--%>

<%@page import="Section.Bean.SectionBean"%>
<%@page import="Section.DAO.SectionDAOImpl"%>
<%@page import="Section.DAO.SectionDAO"%>
<%@page import="Session.Bean.SessionBean"%>
<%@page import="Session.DAO.SessionDAOImpl"%>
<%@page import="Session.DAO.SessionDAO"%>
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
        <title>View Students| Progressive Hostel</title>
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
            .smart-form .row {
                margin: 11px 10px;
            }
        </style>
        <link rel="stylesheet" type="text/css" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
       
        <script>
            function getStudentByFilter() {
                var SESSION_ID = document.getElementById('SESSION_ID').value;
                var CLASS_ID = document.getElementById('CLASS_ID').value;
                var SECTION_ID = document.getElementById('SECTION_ID').value;
                var START_DATE = document.getElementById('START_DATE').value;
                var END_DATE = document.getElementById('END_DATE').value;


                var xmlhttp;
                if (window.XMLHttpRequest) {
                    xmlhttp = new XMLHttpRequest();
                }
                else {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function() {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        document.getElementById('tbody').innerHTML = xmlhttp.responseText;
                    }
                }
                xmlhttp.open("POST", "/ProgressiveHostel/ViewStudentsFilter?SESSION_ID=" + SESSION_ID + "&CLASS_ID=" + CLASS_ID + "&SECTION_ID=" + SECTION_ID + "&START_DATE=" + START_DATE + "&END_DATE=" + END_DATE, true);
                xmlhttp.send();
            }
        </script>
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
                <!-- widget content -->
                <div class="widget-body no-padding">
                    <form action="#" method="POST" id="addClass-form" class="smart-form">
                        <div class="row">
                            <div class="form-group">
                                <fieldset>
                                    <section class="col col-2">
                                        <label class="select">
                                            <select name="SESSION_ID" id="SESSION_ID"> 
                                                <option value="" selected="" disabled="">Select Session</option>
                                                <%
                                                    SessionDAO sessionDAO = new SessionDAOImpl();
                                                    ArrayList<SessionBean> sessionBeanList = sessionDAO.getSessions();
                                                    for (SessionBean sessionBean : sessionBeanList) {
                                                %>
                                                <option value="<%=sessionBean.getSESSION_ID()%>"><%=sessionBean.getSESSION()%></option>
                                                <%
                                                    }
                                                %>
                                            </select> 
                                        </label>
                                    </section>

                                    <section class="col col-2">
                                        <label class="select">
                                            <select name="CLASS_ID" id="CLASS_ID">
                                                <option value="" selected="" disabled="">Select Class</option>
                                                <%
                                                    ClassDAO classDAO = new ClassDAOImpl();
                                                    ArrayList<ClassBean> classBeanList = classDAO.getClasses();
                                                    for (ClassBean classBean : classBeanList) {

                                                %>
                                                <option value="<%=classBean.getCLASS_ID()%>"><%=classBean.getCLASS_NAME()%></option>
                                                <%
                                                    }
                                                %>
                                            </select> <i></i> </label>
                                    </section>
                                    <section class="col col-2">
                                        <label class="select">
                                            <select name="SECTION_ID" id="SECTION_ID">
                                                <option value="" selected="" disabled="">Select Section</option>
                                                <%
                                                    SectionDAO sectionDAO = new SectionDAOImpl();
                                                    ArrayList<SectionBean> sectionBeanList = sectionDAO.getSections();
                                                    for (SectionBean sectionBean : sectionBeanList) {
                                                %>
                                                <option value="<%=sectionBean.getSECTION_ID()%>"><%=sectionBean.getSECTION_NAME()%></option>
                                                <%
                                                    }
                                                %>
                                            </select> 
                                        </label>
                                    </section>
                                    <section class="col col-2" id="From">
                                        <input type="date" name="START_DATE" id="START_DATE"  style="display: inline">
                                    </section>
                                    <section class="col col-2" id="To">
                                        <input type="date" name="END_DATE" id="END_DATE"  style="display: inline">
                                    </section>
                                    <section class="col col-2" id="To">
                                        <button class="btn btn-success" onclick="getStudentByFilter()">Search</button>
                                    </section>    
                                </fieldset>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- end widget content -->

                <table id="example" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <td>S No</td>
                            <td>Session</td>
                            <td>Student Id</td>
                            <td>Student Name</td>
                            <td>Admission No</td>
                            <td>Admission Date</td>
                            <td>Class Name</td>
                            <td>Section Name</td>
                            <td>Roll No</td>
                        </tr>
                    </thead>
                    <tbody id="tbody">
                    </tbody>
                </table>


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
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
        <script>
                                            $(document).ready(function() {
                                                $('#example').DataTable();
                                            });
        </script>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>
