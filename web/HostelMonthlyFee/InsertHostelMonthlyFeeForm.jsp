<%-- 
    Document   : InsertHostelMonthlyFeeForm
    Created on : 25 Apr, 2018, 1:51:29 PM
    Author     : Santosh Kushwaha
--%>


<%@page import="ClassHostelMonthlyFee.Bean.ClassHostelMonthlyFeeBean"%>
<%@page import="ClassHostelMonthlyFee.DAO.ClassHostelMonthlyFeeDAOImpl"%>
<%@page import="ClassHostelMonthlyFee.DAO.ClassHostelMonthlyFeeDAO"%>
<%@page import="Month.Bean.MonthBean"%>
<%@page import="Month.DAO.MonthDAOImpl"%>
<%@page import="Month.DAO.MonthDAO"%>
<%@page import="Section.Bean.SectionBean"%>
<%@page import="Section.DAO.SectionDAOImpl"%>
<%@page import="Section.DAO.SectionDAO"%>
<%@page import="Classes.Bean.ClassBean"%>
<%@page import="Classes.DAO.ClassDAOImpl"%>
<%@page import="Classes.DAO.ClassDAO"%>
<%@page import="Session.Bean.SessionBean"%>
<%@page import="Session.DAO.SessionDAOImpl"%>
<%@page import="Session.DAO.SessionDAO"%>
<%@page import="StudentMaster.Bean.StudentMasterBean"%>
<%@page import="StudentMaster.DAO.StudentMasterDAOImpl"%>
<%@page import="StudentMaster.DAO.StudentMasterDAO"%>
<%@page import="HostelMonthlyFeeLedger.Bean.HostelMonthlyFeeLedgerBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    if (session.getAttribute("USER_ID") != null) {
%>
<%
    HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean = ((HostelMonthlyFeeLedgerBean) session.getAttribute("HostelMonthlyFeeLedgerBean"));
    StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
    StudentMasterBean studentMasterBean = studentMasterDAO.getStudentAllDetailsById(hostelMonthlyFeeLedgerBean.getSTUDENT_ID());
%>
<!DOCTYPE html>
<html lang="en-us">	
    <head>
        <meta charset="utf-8">
        <title>Insert Hostel Monthly Fee Form| Progressive Hostel</title>
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
                            <!--form starts-->
                            <form  id="jvalidate1" role="form" class="form-horizontal" action="/ProgressiveHostel/UpdateHostelMonthlyFeeLedger" method="post" autocomplete="off">
                                <div class="form-group">
                                    <div class="container" id="messageContainerStudentParentDetails" style="margin-left: -32px;">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <%@include file="/IncludeFile/message.jsp"%> 
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="hidden" name="HOSTEL_MONTHLY_FEE_LEDGER_ID" id="HOSTEL_MONTHLY_FEE_LEDGER_ID" value="<%=hostelMonthlyFeeLedgerBean.getHOSTEL_MONTHLY_FEE_LEDGER_ID()%>">
                                        <label>&nbsp;Student Name <span style="color:red;">*</span></label>
                                        <input type="text" style="text-transform: uppercase;" class="form-control" placeholder="" name="STUDENT_NAME" id="STUDENT_NAME" value="<%=studentMasterBean.getSTUDENT_NAME()%>">
                                        <input type="hidden" class="form-control" name="STUDENT_ID" id="STUDENT_ID" value="<%=studentMasterBean.getSTUDENT_ID()%>">
                                        <span class="help-block"></span>
                                    </div>
                                    <div class="col-md-3">
                                        <label>&nbsp;Session<span style="color:red;">*</span></label>
                                        <input type="hidden" class="form-control" placeholder="" name="SESSION_ID" id="SESSION_ID" value="<%=studentMasterBean.getSESSION_ID()%>">
                                        <%
                                            SessionDAO sessionDAO = new SessionDAOImpl();
                                            SessionBean sessionBean = sessionDAO.getSessionById(studentMasterBean.getSESSION_ID());
                                        %>
                                        <input type="text" style="text-transform: uppercase;" class="form-control" placeholder="" name="SESSION" id="SESSION" value="<%=sessionBean.getSESSION()%>">
                                        <span class="help-block"></span>
                                    </div>
                                    <div class="col-md-3">
                                        <label>&nbsp;Admission No<span style="color:red;">*</span></label>
                                        <input type="text" style="text-transform: uppercase;" class="form-control" placeholder="" name="ADMISSION_NO" id="ADMISSION_NO" value="<%=studentMasterBean.getADMISSION_NO()%>">
                                        <span class="help-block"></span>
                                    </div>     
                                </div>

                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label>&nbsp;Class</label>
                                        <input type="hidden" class="form-control" name="CLASS_ID" id="CLASS_ID" value="<%=studentMasterBean.getCLASS_ID()%>">
                                        <%
                                            ClassDAO classDAO = new ClassDAOImpl();
                                            ClassBean classBean = classDAO.getClassById(studentMasterBean.getCLASS_ID());
                                        %>
                                        <input type="text" class="form-control" placeholder="" name="CLASS_NAME" id="CLASS_NAME" value="<%=classBean.getCLASS_NAME()%>">
                                        <span class="help-block"></span>
                                    </div>
                                    <div class="col-md-4">
                                        <label>&nbsp;Section</label>
                                        <input type="hidden" placeholder="" name="SECTION_ID" id="SECTION_ID" value="<%=studentMasterBean.getSECTION_ID()%>">
                                        <%
                                            SectionDAO sectionDAO = new SectionDAOImpl();
                                            SectionBean sectionBean = sectionDAO.getSectionById(studentMasterBean.getSECTION_ID());
                                        %>
                                        <input type="text" class="form-control" placeholder="" name="SECTION" id="SECTION" value="<%=sectionBean.getSECTION_NAME()%>">
                                        <span class="help-block"></span>
                                    </div>
                                    <div class="col-md-4">
                                        <label>&nbsp;Roll No</label>
                                        <input type="text" class="form-control" placeholder="" name="STUDENT_ROLL_NO" id="STUDENT_ROLL_NO" value="<%=studentMasterBean.getSTUDENT_ROLL_NO()%>">
                                        <span class="help-block"></span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-md-6">
                                        <label>&nbsp;Bill Month</label>
                                        <input type="hidden" name="BILL_MONTH_ID" id="BILL_MONTH_ID" value="<%=hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID()%>">
                                        <%
                                            MonthDAO monthDAO = new MonthDAOImpl();
                                            MonthBean monthBean = monthDAO.getMonthById(hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID());
                                        %>
                                        <input type="text" class="form-control" placeholder="" name="BILL_MONTH" id="BILL_MONTH" value="<%=monthBean.getMONTH()%>">
                                        <span class="help-block"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label>&nbsp;Bill Year</label>
                                        <input type="text" class="form-control" placeholder="" name="BILL_YEAR" id="BILL_YEAR" value="<%=hostelMonthlyFeeLedgerBean.getBILL_YEAR()%>">
                                        <span class="help-block"></span>
                                    </div> 
                                </div>

                                <div class="form-group">
                                    <div class="col-md-6">
                                        <label>&nbsp;Current Month Fee</label>
                                        <%
                                            ClassHostelMonthlyFeeDAO classHostelMonthlyFeeDAO = new ClassHostelMonthlyFeeDAOImpl();
                                            ClassHostelMonthlyFeeBean classHostelMonthlyFeeBean = classHostelMonthlyFeeDAO.getClassHostelMonthlyFeeByClassId(studentMasterBean.getCLASS_ID());
                                        %>
                                        <input type="text" class="form-control" placeholder="" name="CURRENT_MONTH_FEE" id="CURRENT_MONTH_FEE" value="<%=classHostelMonthlyFeeBean.getFEE()%>">
                                        <span class="help-block"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label>&nbsp;Arrears Amount</label>
                                        <input type="text" class="form-control" placeholder="" name="ARREARS_AMT" id="ARREARS_AMT" value="<%=hostelMonthlyFeeLedgerBean.getBALANCE_AMT()%>">
                                        <span class="help-block"></span>
                                    </div> 
                                </div>

                                <div class="form-group">
                                    <div class="col-md-6">
                                        <label>&nbsp;Total To Pay</label>
                                        <input type="text" class="form-control" placeholder="" name="TOTAL_TO_PAY" id="TOTAL_TO_PAY" value="">
                                        <span class="help-block"></span>
                                    </div>
                                    <div class="col-md-6">
                                        <label>&nbsp;Total Paid Amount</label>
                                        <input type="text" class="form-control" placeholder="" name="TOTAL_PAID_AMT" id="TOTAL_PAID_AMT">
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

                            <!--form ends-->
                        </div>
                        <!-- widget content -->

                    </div>
                    <!-- widget div-->
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

