<%-- 
    Document   : StudentOneTimeChargesSlip
    Created on : 28 Apr, 2018, 12:50:43 PM
    Author     : Santosh Kushwaha
--%>

<%@page import="StudentOneTimeChargeDetails.Bean.StudentOneTimeChargeDetailsBean"%>
<%@page import="StudentOneTimeChargeDetails.DAO.StudentOneTimeChargeDetailsDAOImpl"%>
<%@page import="StudentOneTimeChargeDetails.DAO.StudentOneTimeChargeDetailsDAO"%>
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
<%    if (session.getAttribute("USER_ID") != null) {
%>
<%
    int STUDENT_ID = (Integer) session.getAttribute("STUDENT_ID");
    StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
    StudentMasterBean studentMasterBean = studentMasterDAO.getStudentAllDetailsById(STUDENT_ID);

    StudentOneTimeChargeDetailsDAO studentOneTimeChargeDetailsDAO = new StudentOneTimeChargeDetailsDAOImpl();
    StudentOneTimeChargeDetailsBean studentOneTimeChargeDetailsBean = studentOneTimeChargeDetailsDAO.getStudentOneTimeChargeDetailsByStudentId(STUDENT_ID);

%>
<!doctype html>
<html lang="en">
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <style>
        .cont{width:793.66px; height:1122.52px;}
        .a{width: 793.66px; height: 1122.52px; float: left;}
        p.title{margin-bottom: -14px; font-size: 28px; font-weight: 600;}
        p.title1{font-size: 20px;margin-bottom: -3px;}
        p.title2{font-size: 12px;margin-bottom: 0;}
        p.title3{margin-bottom: 0px;font-size: 18px;}
        p.title4{margin: 6px 0 0 0;font-size: 16px;font-weight: 600;}
        td{padding: 1px 13px!important;}
        th{padding: 3px 13px!important;}
    </style>
    <body>
        <div class="cont">
            <div class="a">
                <div class="">
                    <p class="title text-center">Student One Time Fee Admission Slip</p>
                    <p class="title1 text-center">Progressive Hostel</p>
                    <p class="title2 text-center">(Ranchi-Patna Road, Jhumri Telaiya)</p>
                    <p class="title3 text-center">Student Copy</p>
                </div>
                <table class="table table-bordered" style="width: 95%; margin: auto;">
                    <tr>
                        <%                            SessionDAO SessionDAO = new SessionDAOImpl();
                            int SESSION_ID = studentMasterBean.getSESSION_ID();
                            SessionBean sessionBean = SessionDAO.getSessionById(SESSION_ID);
                        %>
                        <td class="">Session - <%=sessionBean.getSESSION()%></td>
                        <%
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        %>
                        <td class="">Date of Admission - <%=sdf.format(studentMasterBean.getENTRY_DATE())%></td>
                    </tr>
                    <tr>
                        <td class="">Student Name - <%=studentMasterBean.getSTUDENT_NAME().toUpperCase()%></td>
                        <%
                            ClassDAO classDAO = new ClassDAOImpl();
                            int CLASS_ID = studentMasterBean.getCLASS_ID();
                            ClassBean classBean = classDAO.getClassById(CLASS_ID);
                        %>
                        <td class="">Class - <%=classBean.getCLASS_NAME()%></td>
                    </tr>
                    <tr>
                        <%
                            SectionDAO sectionDAO = new SectionDAOImpl();
                            int SECTION_ID = studentMasterBean.getSECTION_ID();
                            SectionBean sectionBean = sectionDAO.getSectionById(SECTION_ID);
                        %>
                        <td class="">Section - <%=sectionBean.getSECTION_NAME()%></td>
                        <td class="">Roll No - <%=studentMasterBean.getSTUDENT_ROLL_NO()%></td>
                    </tr>
                    <tr>
                        <td class="">Father's Name - <%=studentMasterBean.getStudentParentDetailsBean().getSTUDENT_FATHER_NAME().toUpperCase()%></td>
                        <td class="">Admission No. - <%=studentMasterBean.getADMISSION_NO()%>&nbsp;&nbsp;&nbsp; Student ID - <%=studentMasterBean.getSTUDENT_ID()%></td>
                    </tr>
                </table>
                <p class="title4 text-center">One Time Fee Details</p>
                <table class="table table-bordered" style="width: 95%; margin: auto;">
                    <tr>
                        <th>S.No.</th>
                        <th>Fee</th>
                        <th>Amount</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Security Money</td>
                        <td><%=studentOneTimeChargeDetailsBean.getSECURITY_MONEY()%></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Pocket Money</td>
                        <td><%=studentOneTimeChargeDetailsBean.getPACKET_MONEY()%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Total to Pay</td>
                        <td><%=studentOneTimeChargeDetailsBean.getTOTAL_TO_PAY()%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Total Amount Paid</td>
                        <td><%=studentOneTimeChargeDetailsBean.getTOTAL_PAID_AMT()%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Total Balance Amount</td>
                        <td><%=studentOneTimeChargeDetailsBean.getBALANCE_AMT()%></td>
                    </tr>
                </table>
                <br><br>
                <table class="table" style="width: 95%; margin: auto;">
                    <tr>
                        <td class="" style="border-top:none;">Student's Sign</td>
                        <td class="" style="border-top:none; text-align:right;">Warden's Sign</td>
                    </tr>
                </table>
                <br>
                <hr style="border: 0.5px dashed black;">
                <br>
                <div class="">
                    <div class="">
                        <p class="title text-center">Student Security Deposit Slip</p>
                        <p class="title1 text-center">Progressive Hostel</p>
                        <p class="title2 text-center">(Ranchi-Patna Road, Jhumri Telaiya)</p>
                        <p class="title3 text-center">Student Copy</p>
                    </div>
                    <table class="table table-bordered" style="width: 95%; margin: auto;">
                        <tr>
                            <td class="">Session - <%=sessionBean.getSESSION()%></td>
                            <td class="">Date of Admission - <%=sdf.format(studentMasterBean.getENTRY_DATE())%></td>
                        </tr>
                        <tr>
                            <td class="">Student Name - <%=studentMasterBean.getSTUDENT_NAME().toUpperCase()%></td>
                            <td class="">Class - <%=classBean.getCLASS_NAME()%></td>
                        </tr>
                        <tr>
                            <td class="">Section - <%=sectionBean.getSECTION_NAME()%></td>
                            <td class="">Roll No - <%=studentMasterBean.getSTUDENT_ROLL_NO()%></td>
                        </tr>
                        <tr>
                            <td class="">Admission No. - <%=studentMasterBean.getADMISSION_NO()%>&nbsp;&nbsp;&nbsp; Student ID - <%=studentMasterBean.getSTUDENT_ID()%></td>
                            <td class="">Security Money - <%=studentOneTimeChargeDetailsBean.getSECURITY_MONEY()%></td>
                        </tr>
                    </table>
                    <br><br>
                    <table class="table" style="width: 95%; margin: auto;">
                        <tr>
                            <td class="" style="border-top:none;">Student's Sign</td>
                            <td class="" style="border-top:none; text-align:right;">Warden's Sign</td>
                        </tr>
                    </table>
                </div>

            </div>

        </div>
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>