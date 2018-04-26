<%-- 
    Document   : NewStudentAddmissionSlip
    Created on : 23 Apr, 2018, 4:02:50 PM
    Author     : mishra
--%>

<%@page import="Section.Bean.SectionBean"%>
<%@page import="Section.DAO.SectionDAOImpl"%>
<%@page import="Section.DAO.SectionDAO"%>
<%@page import="Classes.Bean.ClassBean"%>
<%@page import="Classes.DAO.ClassDAOImpl"%>
<%@page import="Classes.DAO.ClassDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Session.Bean.SessionBean"%>
<%@page import="Session.DAO.SessionDAOImpl"%>
<%@page import="Session.DAO.SessionDAO"%>
<%@page import="StudentMaster.Bean.StudentMasterBean"%>
<%@page import="StudentMaster.DAO.StudentMasterDAOImpl"%>
<%@page import="StudentMaster.DAO.StudentMasterDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int STUDENT_ID = (Integer) session.getAttribute("STUDENT_ID");
    StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
    StudentMasterBean studentMasterBean = studentMasterDAO.getStudentAllDetailsById(STUDENT_ID);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>New Student Admission Slip | Progressive Hostel</title>

        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="/ProgressiveHostel/assets/css/font-awesome.min.css">
        <style>
            body {
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
                background-color: #FAFAFA;
                font: 12pt "monospace";
            }
            * {
                box-sizing: border-box;
                -moz-box-sizing: border-box;
            }
            .page {
                width: 210mm;
                min-height: 297mm;
                padding: 2mm;
                margin: 10mm auto;
                border: 1px #D3D3D3 solid;
                border-radius: 5px;
                background: white;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            }
            .subpage {
                padding: 1cm;
                border: 5px red solid;
                height: 257mm;
                outline: 2cm #FFEAEA solid;
            }

            @page {
                size: A4;
                margin: 0;
            }
            @media print {
                html, body {
                    width: 210mm;
                    height: 297mm;        
                }
                .page {
                    margin: 0;
                    border: initial;
                    border-radius: initial;
                    width: initial;
                    min-height: initial;
                    box-shadow: initial;
                    background: initial;
                    page-break-after: always;
                }
            }
            h2
            {
                font-size: 27px; font-family: initial; margin-bottom: 0px; margin-top: 5px; font-weight: 800;
            }
            h4
            {
                font-size: 13px !important;
            }
            h3{
                font-weight: 800;
                font-size: 16px;
            }
            ul li
            {
                margin-bottom: 15px;
            }

        </style>
        <script>
            window.print();
            window.close();
        </script>
    </head>
    <body onload="print()">
        <div class="book"> 
            <div class="page container">
                <center>
                    <h2>New Student Hostel Admission Form</h2>
                    <h2>Progressive Hostel</h2>
                    <h4>(Ranchi-Patna Road,  Jhumri Telaiya) </h4> 
                    <h3 style="margin-top: 22px;background-color:#bdbcbc; padding: 9px;"> Home Away Home </h3>

                </center>
                <div class="container">
                    <div class="row" style="margin-left: -13px; margin-right: 183px; margin-top: 8px;">
                        <div class="col-md-6">
                            <label>Session :</label>
                            <%                                SessionDAO SessionDAO = new SessionDAOImpl();
                                int SESSION_ID = studentMasterBean.getSESSION_ID();
                                SessionBean sessionBean = SessionDAO.getSessionById(SESSION_ID);
                            %>
                            <span><%=sessionBean.getSESSION()%></span>
                        </div>
                        <div class="col-md-6">
                            <label>Date Of Admission :</label>
                            <%
                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            %>
                            <span><%=sdf.format(studentMasterBean.getENTRY_DATE())%></span>
                        </div>
                    </div>
                    <br><br>
                    <div class="row">
                        <div class="col-md-12">
                            <label>Student Name: </label>&nbsp;
                            <span><%=studentMasterBean.getSTUDENT_NAME()%></span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-3">
                            <%
                                ClassDAO classDAO = new ClassDAOImpl();
                                int CLASS_ID = studentMasterBean.getCLASS_ID();
                                ClassBean classBean = classDAO.getClassById(CLASS_ID);
                            %>
                            <label>Class : </label>
                            <span><%=classBean.getCLASS_NAME()%></span>
                        </div>
                        <div class="col-md-3">
                            <%
                                SectionDAO sectionDAO = new SectionDAOImpl();
                                int SECTION_ID = studentMasterBean.getSECTION_ID();
                                SectionBean sectionBean = sectionDAO.getSectionById(SECTION_ID);
                            %>
                            <label>Section :</label>
                            <span><%=sectionBean.getSECTION_NAME()%></span>
                        </div>
                        <div class="col-md-3">
                            <label>Roll No :</label>
                            <span><%=studentMasterBean.getSTUDENT_ROLL_NO()%></span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Date of Birth: </label>
                            <span><%=sdf.format(studentMasterBean.getSTUDENT_DOB())%></span>
                        </div>
                        <div class="col-md-6">
                            <label>Admission No: </label>
                            <span><%=studentMasterBean.getADMISSION_NO()%></span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12">
                            <label>Father's Name: </label>
                            <span><%=studentMasterBean.getStudentParentDetailsBean().getSTUDENT_FATHER_NAME()%></span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12">
                            <label>Father's Occupation: </label>
                            <span><%=studentMasterBean.getStudentParentDetailsBean().getSTUDENT_FATHER_OCCUPATION()%></span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12">
                            <label>Father's Mobile Number: </label>
                            <span><%=studentMasterBean.getStudentParentDetailsBean().getSTUDENT_FATHER_MOBILE_NUMBER()%></span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12">
                            <label>Address: </label>&nbsp;
                            <span>
                                <%=studentMasterBean.getStudentAddressDetailsBean().getSTUDENT_C_ADDRESS()%>,&nbsp;
                                <%=studentMasterBean.getStudentAddressDetailsBean().getSTUDENT_C_CITY()%>,&nbsp;
                                <%=studentMasterBean.getStudentAddressDetailsBean().getSTUDENT_C_STATE()%>,&nbsp;
                                <%=studentMasterBean.getStudentAddressDetailsBean().getSTUDENT_C_PIN_CODE()%>
                            </span>
                        </div>
                    </div>   
                    <br>
                    <br>
                    <div class="row" style="margin-left: 1px; margin-right: 399px;">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th colspan="3">
                                        One Time Fee Details
                                    </th> 
                                </tr>
                                <tr>
                                    <th style="width: 1px;">Sno</th>
                                    <th scope="col">Fee Head</th>
                                    <th scope="col">Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Security Money</td>
                                    <td><%=studentMasterBean.getStudentOneTimeChargeDetailsBean().getSECURITY_MONEY()%></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Pocket Money</td>
                                    <td><%=studentMasterBean.getStudentOneTimeChargeDetailsBean().getPACKET_MONEY()%></td>
                                </tr>
                                <tr>
                                    <td colspan="2">Total To Pay</td>
                                    <td><%=studentMasterBean.getStudentOneTimeChargeDetailsBean().getTOTAL_TO_PAY()%></td>
                                </tr>
                                <tr>
                                    <td colspan="2">Total Paid Amount</td>
                                    <td><%=studentMasterBean.getStudentOneTimeChargeDetailsBean().getTOTAL_PAID_AMT()%></td>
                                </tr>
                                <tr>
                                    <td colspan="2">Total Balance Amount</td>
                                    <td><%=studentMasterBean.getStudentOneTimeChargeDetailsBean().getBALANCE_AMT()%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <br><br><br><br><br><br><br><br><br><br><br><br>
                    <div class="row">
                        <div class="col-md-12">
                            <p style="float: right; margin-right: 422px; font-weight: bold;">( Signatue of Hostel Warden )</p>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </body>
</html>
