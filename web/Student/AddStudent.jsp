<%-- 
    Document   : AddStudent
    Created on : 21 Apr, 2018, 3:30:36 PM
    Author     : Santosh Kushwaha
--%>

<%@page import="OneTimeCharges.Bean.OneTimeChargeBean"%>
<%@page import="OneTimeCharges.DAO.OneTimeChargesDAOImpl"%>
<%@page import="OneTimeCharges.DAO.OneTimeChargesDAO"%>
<%@page import="Section.Bean.SectionBean"%>
<%@page import="Section.DAO.SectionDAOImpl"%>
<%@page import="Section.DAO.SectionDAO"%>
<%@page import="Classes.Bean.ClassBean"%>
<%@page import="Classes.DAO.ClassDAOImpl"%>
<%@page import="Classes.DAO.ClassDAO"%>
<%@page import="Session.Bean.SessionBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Session.DAO.SessionDAOImpl"%>
<%@page import="Session.DAO.SessionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    if (session.getAttribute("USER_ID") != null) {
%> 
<%
    int i = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html>
<html lang="en-us">	
    <head>
        <meta charset="utf-8">
        <title>Add Student | Progressive Hostel</title>
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
        <script>
            function getAddressData()
            {
                if (document.getElementById('SAME_ADDRESS').checked == true)
                {
                    alert("Are you sure your correspondence address is same as permanent address");
                    document.getElementById('STUDENT_P_ADDRESS').value = document.getElementById('STUDENT_C_ADDRESS').value
                    document.getElementById('STUDENT_P_STATE').value = document.getElementById('STUDENT_C_STATE').value
                    document.getElementById('STUDENT_P_CITY').value = document.getElementById('STUDENT_C_CITY').value
                    document.getElementById('STUDENT_P_PIN_CODE').value = document.getElementById('STUDENT_C_PIN_CODE').value
                }
                else
                {
                    document.getElementById('STUDENT_P_ADDRESS').value = "";
                    document.getElementById('STUDENT_P_STATE').value = "";
                    document.getElementById('STUDENT_P_CITY').value = "";
                    document.getElementById('STUDENT_P_PIN_CODE').value = "";
                }
            }
        </script>
        <script src="/ProgressiveHostel/utils.js"></script> 
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
                <div class="container">
                    <div class="row" style="margin-left: 0px;margin-right: -32px;">
                        <div class="col-md-11" style="background-color: #69a5e5; border: 1px solid #69a5e5; height: 50px; width: 93%; color:white">
                            <h3 style="font-family: Tahoma; text-align: center;">Student Admission Form</h3>  
                        </div> 
                    </div>
                </div>
                <div class="container-fluid">
                    <!-- NAV TAB START-->
                    <div class="panel panel-default tabs">
                        <ul class="nav nav-tabs nav-justified">
                            <%
                                if (i == 0) {
                            %>
                            <li class="active"><a href="#tab1" data-toggle="tab">Basic Details</a></li>
                            <li class="disabled"><a data-toggle="tab">Parent's Details</a></li>
                            <li class="disabled"><a data-toggle="tab">Address Details</a></li> 
                            <li class="disabled"><a data-toggle="tab">Document Details</a></li>

                            <%
                                }
                            %>
                            <%
                                if (i == 1) {
                            %>
                            <li class="disabled"><a data-toggle="tab">Basic Details</a></li>
                            <li class="active"><a href="#tab2" data-toggle="tab">Parent's Details</a></li>
                            <li class="disabled"><a data-toggle="tab">Address Details</a></li> 
                            <li class="disabled"><a data-toggle="tab">Document Details</a></li>
                                <%
                                    }
                                %>
                                <%
                                    if (i == 2) {
                                %>
                            <li class="disabled"><a data-toggle="tab">Basic Details</a></li>
                            <li class="disabled"><a data-toggle="tab">Parent's Details</a></li>
                            <li class="active"><a href="#tab3" data-toggle="tab">Address Details</a></li> 
                            <li class="disabled"><a data-toggle="tab">Document Details</a></li>
                                <%
                                    }
                                %>
                                <%
                                    if (i == 3) {
                                %>
                            <li class="disabled"><a data-toggle="tab">Basic Details</a></li>
                            <li class="disabled"><a data-toggle="tab">Parent's Details</a></li>
                            <li class="disabled"><a data-toggle="tab">Address Details</a></li> 
                            <li class="active"><a href="#tab5" data-toggle="tab">Document Details</a></li>
                                <%
                                    }
                                %>
                                <%
                                    if (i == 4) {
                                %>
                                <%
                                    }
                                %>


                        </ul>
                        <div class="panel-body tab-content">
                            <%
                                if (i == 0) {
                            %>
                            <div class="tab-pane active" id="tab1">
                                <%
                                } else {
                                %>
                                <div class="tab-pane" id="tab1">
                                    <%
                                        }
                                    %>
                                    <form  id="jvalidate" role="form" action="/ProgressiveHostel/AddStudentMaster" class="form-horizontal" method="post" autocomplete="off">
                                        <div class="form-group">
                                            <div class="container" id="messageContainerStudentMaster" style="margin-left: -32px;">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <%@include file="/IncludeFile/message.jsp"%> 
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <label>&nbsp;Session <span style="color:red;">*</span></label>
                                                <select class="form-control" name="SESSION_ID" id="SESSION_ID" required=""> 
                                                    <option value="" selected="" disabled="">Select</option>
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
                                                <span class="help-block"></span>
                                            </div>
                                            <div class="col-md-6">
                                                <label>&nbsp;Student Name <span style="color:red;">*</span></label>
                                                <input type="STUDENT_NAME" class="form-control" placeholder="" name="STUDENT_NAME" id="STUDENT_NAME" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required="">
                                                <!--<span class="help-block" id=""></span>-->
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-6">
                                                <label>&nbsp;Class<span style="color:red;">*</span></label>
                                                <select class="form-control" name="CLASS_ID" id="CLASS_ID" required="" onchange="getSectionsByClassId(this.value)">
                                                    <option value="" selected="" disabled="">Select</option>
                                                    <%
                                                        ClassDAO classDAO = new ClassDAOImpl();
                                                        ArrayList<ClassBean> classBeanList = classDAO.getClasses();
                                                        for (ClassBean classBean : classBeanList) {

                                                    %>
                                                    <option value="<%=classBean.getCLASS_ID()%>"><%=classBean.getCLASS_NAME()%></option>
                                                    <%
                                                        }
                                                    %>

                                                </select> 
                                                <span class="help-block"></span>
                                            </div>
                                            <div class="col-md-6">
                                                <label>&nbsp;Section<span style="color:red;">*</span></label>
                                                <select class="form-control" name="SECTION_ID" id="SECTION_ID" required="">
                                                </select> 
                                                <span class="help-block"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-6">
                                                <label>&nbsp;Roll No <span style="color:red;">*</span></label>
                                                <input type="number" class="form-control" placeholder="" name="STUDENT_ROLL_NO" id="STUDENT_ROLL_NO" minlength="1" maxlength="3" onkeypress="checkNumber(event)" required="">
                                                <span class="help-block"></span>
                                            </div>
                                            <div class="col-md-6">
                                                <label>&nbsp;Date Of Birth</label>
                                                <input type="date" class="form-control" placeholder="" name="STUDENT_DOB" id="STUDENT_DOB" required="">
                                                <span class="help-block"></span>
                                            </div> 
                                        </div>

                                        <div class="form-group">
                                            <div class="col-md-8">
                                            </div> 
                                            <div class="col-md-4">
                                                <button class="btn btn-warning" style="float: right;" id="btn">Next</button>
                                            </div> 
                                        </div> 
                                    </form>
                                </div> 







                                <%
                                    if (i == 1) {
                                %>
                                <div class="tab-pane active" id="tab2">
                                    <%
                                    } else {
                                    %>
                                    <div class="tab-pane" id="tab2">
                                        <%
                                            }
                                        %>
                                        <form  id="jvalidate1" role="form" class="form-horizontal" action="/ProgressiveHostel/AddStudentParentDetails" method="post" autocomplete="off">
                                            <div class="form-group">
                                                <div class="container" id="messageContainerStudentParentDetails" style="margin-left: -32px;">
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <%@include file="/IncludeFile/message.jsp"%> 
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <label>&nbsp;Father's Name <span style="color:red;">*</span></label>
                                                    <input type="text" style="text-transform: uppercase;" class="form-control" placeholder="" name="STUDENT_FATHER_NAME" id="STUDENT_FATHER_NAME" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required="">
                                                    <span class="help-block"></span>
                                                </div>
                                                <div class="col-md-6">
                                                    <label>&nbsp;Mother's Name <span style="color:red;">*</span></label>
                                                    <input type="text" style="text-transform: uppercase;" class="form-control" placeholder="" name="STUDENT_MOTHER_NAME" id="STUDENT_MOTHER_NAME" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" requiried="">
                                                    <span class="help-block"></span>
                                                </div> 
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-6">
                                                    <label>&nbsp;Father Mobile Number</label>
                                                    <input type="number" class="form-control" placeholder="" name="STUDENT_FATHER_MOBILE_NUMBER" id="STUDENT_FATHER_MOBILE_NUMBER" minlength="10" maxlength="11" onkeypress="checkNumber(event)" required="">
                                                    <span class="help-block"></span>
                                                </div>
                                                <div class="col-md-6">
                                                    <label>&nbsp;Mother Mobile Number</label>
                                                    <input type="number" class="form-control" placeholder="" name="STUDENT_MOTHER_MOBILE_NUMBER" id="STUDENT_MOTHER_MOBILE_NUMBER" minlength="10" maxlength="11" onkeypress="checkNumber(event)" required="">
                                                    <span class="help-block"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-6">
                                                    <label>&nbsp;Father Occupation</label>
                                                    <input type="text" class="form-control" placeholder="" name="STUDENT_FATHER_OCCUPATION" id="STUDENT_FATHER_OCCUPATION" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required="">
                                                    <span class="help-block"></span>
                                                </div>
                                                <div class="col-md-6">
                                                    <label>&nbsp;Mother Occupation</label>
                                                    <input type="text" class="form-control" placeholder="" name="STUDENT_MOTHER_OCCUPATION" id="STUDENT_MOTHER_OCCUPATION" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required="">
                                                    <span class="help-block"></span>
                                                </div> 
                                            </div> 

                                            <div class="form-group">
                                                <div class="col-md-6">
                                                    <label>&nbsp;Guardian Name</label>
                                                    <input type="text" class="form-control" placeholder="" name="STUDENT_GUARDIAN_NAME" id="STUDENT_GUARDIAN_NAME" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)">
                                                    <span class="help-block"></span>
                                                </div>
                                                <div class="col-md-6">
                                                    <label>&nbsp;Guardian Moblie</label>
                                                    <input type="text" class="form-control" placeholder="" name="STUDENT_GUARDIAN_MOBILE" id="STUDENT_GUARDIAN_MOBILE" minlength="10" maxlength="15" onkeypress="return checkNumber(event)">
                                                    <span class="help-block"></span>
                                                </div> 
                                            </div>

                                            <div class="form-group">
                                                <div class="col-md-8">
                                                </div> 
                                                <div class="col-md-4">
                                                    <button class="btn btn-warning" style="float: right;">Next</button>
                                                </div> 
                                            </div> 
                                        </form>
                                    </div> 














                                    <%
                                        if (i == 2) {
                                    %>
                                    <div class="tab-pane active" id="tab3">
                                        <%
                                        } else {
                                        %>
                                        <div class="tab-pane" id="tab3">
                                            <%
                                                }
                                            %>
                                            <form  id="jvalidate2" role="form" class="form-horizontal" action="/ProgressiveHostel/AddStudentAddressDetails" method="post" autocomplete="off">
                                                <div class="container" id="messageContainerStudentAddressDetails" style="margin-left: -32px;">
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <%@include file="/IncludeFile/message.jsp"%> 
                                                        </div>
                                                    </div>
                                                </div>
                                                <h1 style="color: #9e4f06; width: 100%; text-align: left; padding: 0px; font-weight: 700; font-family: initial;">Correspondence Address</h1>
                                                <div class="form-group">
                                                    <div class="col-md-6">
                                                        <label>&nbsp;Address <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_C_ADDRESS" id="STUDENT_C_ADDRESS" minlength="3" maxlength="40" required="">
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label>&nbsp;State <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_C_STATE" id="STUDENT_C_STATE" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required="">
                                                        <span class="help-block"></span>
                                                    </div> 
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-6">
                                                        <label>&nbsp;City <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_C_CITY" id="STUDENT_C_CITY" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required="">
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label>&nbsp;Pin Code <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_C_PIN_CODE" id="STUDENT_C_PIN_CODE" minlenth="6" maxlength="6" onkeypress="return checkNumber(event)" required=""> 
                                                        <span class="help-block"></span>
                                                    </div> 
                                                </div> 

                                                <div class="form-group">
                                                    <div style="margin-left: 17px;">
                                                        <p style="display: inline;">If correspondence address same as permanent address then Check Box</p>&nbsp;
                                                        <input type="checkbox" id="SAME_ADDRESS" onclick="getAddressData()" style="display: inline;">
                                                        <!--                                                        <select name="SAME_ADDRESS" id="SAME_ADDRESS" onchange="getAddressData(this.value)">
                                                                                                                    <option value="" selected="" disabled="">Select</option>
                                                                                                                    <option value="1">Yes</option>
                                                                                                                    <option value="0">No</option>
                                                                                                                </select>-->
                                                        <h1 style="color: #9e4f06; width: 100%; text-align: left; padding: 0px; font-weight: 700; font-family: initial;">Permanent Address</h1>
                                                    </div>

                                                    <div class="col-md-6">
                                                        <label>&nbsp;Address <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_P_ADDRESS" id="STUDENT_P_ADDRESS" minlength="3" maxlength="40" required="">
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label>&nbsp;State <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_P_STATE" id="STUDENT_P_STATE" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required="">
                                                        <span class="help-block"></span>
                                                    </div> 
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-6">
                                                        <label>&nbsp;City <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_P_CITY" id="STUDENT_P_CITY" minlength="3" maxlength="40" onkeypress="return checkAlpha(event)" required=""> 
                                                        <span class="help-block"></span>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label>&nbsp;Pin Code <span style="color:red;">*</span></label>
                                                        <input type="text" class="form-control" placeholder="" name="STUDENT_P_PIN_CODE" id="STUDENT_P_PIN_CODE" minlenth="6" maxlength="6" onkeypress="return checkNumber(event)" required="">
                                                        <span class="help-block"></span> 
                                                    </div> 
                                                </div>                    
                                                <div class="form-group">
                                                    <div class="col-md-8">
                                                    </div> 
                                                    <div class="col-md-4">
                                                        <button class="btn btn-warning" style="float: right;">Next</button>
                                                    </div> 
                                                </div> 
                                            </form>
                                        </div> 








                                        <%
                                            if (i == 3) {
                                        %>
                                        <div class="tab-pane active" id="tab5">
                                            <%
                                            } else {
                                            %>
                                            <div class="tab-pane" id="tab5">
                                                <%
                                                    }
                                                %> 
                                                <form  id="jvalidate4" role="form" class="form-horizontal" action="/ProgressiveHostel/AddStudentDocumentDetails" method="post" autocomplete="off" enctype="multipart/form-data">
                                                    <div class="container" id="messageContainerStudentDocumentDetails" style="margin-left: -32px;">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <%@include file="/IncludeFile/message.jsp"%> 
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <p style='color: red; font-weight: 700;'>Note * : Photo size must be smaller than 250 kb and image file accept only jpeg file.</p>
                                                    <div class="form-group">
                                                        <div class="col-md-6">
                                                            <label>&nbsp;Student Photo<span style="color:red;">*</span></label>
                                                            <input type="file" class="form-control" name="STUDENT_PHOTO_DOC" id="STUDENT_PHOTO_DOC" accept="image/jpeg" onchange="readURL(this), GetFileSize(this.id);">
                                                            <span class="help-block"></span>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <label>&nbsp;Student Aadhar<span style="color:red;">*</span></label>
                                                            <input type="file" class="form-control"  name="STUDENT_AADHAR_DOC" id="STUDENT_AADHAR_DOC" accept="image/jpeg" onchange="readURL(this), GetFileSize(this.id);">
                                                            <span class="help-block"></span>
                                                        </div> 
                                                    </div>    
                                                    <div class="form-group">
                                                        <div class="col-md-6">
                                                            <label>&nbsp;Student School ID <span style="color:red;">*</span></label>
                                                            <input type="file" class="form-control" name="STUDENT_SCHOOL_ID_DOC" id="STUDENT_SCHOOL_ID_DOC" accept="image/jpeg" onchange="readURL(this), GetFileSize(this.id);">
                                                            <span class="help-block"></span>
                                                        </div>
                                                    </div>    

                                                    <div class="form-group">
                                                        <div class="col-md-8">
                                                        </div> 
                                                        <div class="col-md-4">
                                                            <button class="btn btn-warning" style="float: right;">Submit</button>
                                                        </div> 
                                                    </div> 
                                                </form>
                                            </div>





                                        </div>
                                    </div>      
                                </div>
                            </div> 
                        </div>  
                    </div> 


                    <!-- NAV TAB ENDS-->
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
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>
