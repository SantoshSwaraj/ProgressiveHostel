<%-- 
    Document   : UpdatedHostelMonthlyFeeSlip
    Created on : 4 May, 2018, 5:44:39 PM
    Author     : Santosh Kushwaha
--%>

<%@page import="HostelMonthlyFeeLedger.Bean.HostelMonthlyFeeLedgerBean"%>
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
<%@page import="StudentOneTimeChargeDetails.Bean.StudentOneTimeChargeDetailsBean"%>
<%@page import="StudentOneTimeChargeDetails.DAO.StudentOneTimeChargeDetailsDAOImpl"%>
<%@page import="StudentOneTimeChargeDetails.DAO.StudentOneTimeChargeDetailsDAO"%>
<%@page import="StudentMaster.Bean.StudentMasterBean"%>
<%@page import="StudentMaster.DAO.StudentMasterDAOImpl"%>
<%@page import="StudentMaster.DAO.StudentMasterDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    if (session.getAttribute("USER_ID") != null) {
%>
<%
    HostelMonthlyFeeLedgerBean hostelMonthlyFeeLedgerBean = (HostelMonthlyFeeLedgerBean) session.getAttribute("HostelMonthlyFeeLedgerBean");
    int STUDENT_ID = hostelMonthlyFeeLedgerBean.getSTUDENT_ID();
    StudentMasterDAO studentMasterDAO = new StudentMasterDAOImpl();
    StudentMasterBean studentMasterBean = studentMasterDAO.getStudentAllDetailsById(STUDENT_ID);

%>
<!doctype html>
<html lang="en">
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                    <p class="title text-center">Student Monthly Fee Slip</p>
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
                        <td class="">Father's Name - <%=studentMasterBean.getStudentParentDetailsBean().getSTUDENT_FATHER_NAME()%></td>
                        <td class="">Admission No. - <%=studentMasterBean.getADMISSION_NO()%>,&nbsp;&nbsp;&nbsp;Student ID - <%=studentMasterBean.getSTUDENT_ID()%></td>
                    </tr>
                </table>
                <p class="title4 text-center">Monthly Fee Details for Month <%=hostelMonthlyFeeLedgerBean.getBILL_MONTH_ID()%>, Year-<%=hostelMonthlyFeeLedgerBean.getBILL_YEAR()%></p>
                <table class="table table-bordered" style="width: 95%; margin: auto;">
                    <tr>
                        <td colspan="2">Bill No - <%=hostelMonthlyFeeLedgerBean.getBILL_NO()%></td>
                        <td  class=""></td>
                    </tr>
                    <tr>
                        <td colspan="2">Current Month Monthly Fee</td>
                        <td><i class="fa fa-rupee"></i><%=hostelMonthlyFeeLedgerBean.getCURRENT_MONTH_FEE()%></td> 
                    </tr> 
                    <tr>
                        <td colspan="2">Arrears Amount</td>
                        <td><i class="fa fa-rupee"></i><%=hostelMonthlyFeeLedgerBean.getARREARS_AMT()%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Total To Pay</td>
                        <td><i class="fa fa-rupee"></i><%=hostelMonthlyFeeLedgerBean.getTOTAL_TO_PAY()%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Total Paid Amount</td>
                        <td><i class="fa fa-rupee"></i><%=hostelMonthlyFeeLedgerBean.getTOTAL_PAID_AMT()%></td>
                    </tr>
                    <tr>
                        <td colspan="2">Dues Amount</td>
                        <td><i class="fa fa-rupee"></i><%=hostelMonthlyFeeLedgerBean.getBALANCE_AMT()%></td>
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
    </body>
</html>
<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>

