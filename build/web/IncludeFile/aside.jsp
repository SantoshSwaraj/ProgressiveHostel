<%-- 
    Document   : aside
    Created on : 19 Apr, 2018, 12:36:51 PM
    Author     : Santosh Kushwaha
--%>
<%@page import="User.UserBean"%>
<%
    int USER_ID = (Integer) session.getAttribute("USER_ID");
    UserBean userBean = User.Query.viewUserRegById(USER_ID);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- #NAVIGATION -->
<!-- Left panel : Navigation area -->
<!-- Note: This width of the aside area can be adjusted through LESS/SASS variables -->

<aside id="left-panel">

    <!-- User info -->
    <div class="login-info">
        <span> <!-- User image size is adjusted inside CSS, it should stay as is --> 

            <a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
                <!--<img src="/ProgressiveHostel/assets/img/avatars/sunny.png" alt="me" class="online" />-->
                <span></span>
                <span>
                    Welcome! <%=userBean.getEMP_NAME()%>
                </span>
                <i class="fa fa-angle-down"></i>
            </a> 

        </span>
    </div>
    <nav>
        <ul id="MainMenu">
            <li class="">
                <a href="/ProgressiveHostel/AdminDashboard.jsp" title="Dashboard"><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Dashboard</span></a>
            </li>
            <li class="">
                <a href="#" title="New Student Admission"><i class="fa fa-lg fa-fw fa-cube txt-color-blue"></i> <span class="menu-item-parent"> New Admission</span></a>
                <ul>
                    <li class=""> 
                        <a href="/ProgressiveHostel/Student/AddStudent.jsp?id=<%=0%>" title="Add New Student"><i class="fa fa-cube"></i> <span class="menu-item-parent">Admission Form</span></a>
                    </li> 
                    <li class=""> 
                        <a href="/ProgressiveHostel/OneTimeCharges/OneTimeChargeForm.jsp" title="One Time Charges"><i class="fa fa-cube"></i> <span class="menu-item-parent">One Time Charges</span></a>
                    </li> 
                    <li class="">
                        <a href="/ProgressiveHostel/Student/ViewStudents.jsp" title="View All Student"><i class="fa fa-lg fa-fw fa-picture-o"></i>&nbsp;<span class="menu-item-parent"> View All Student</span></a>
                    </li>
                </ul>	
            </li>
            <li class="top-menu-invisible">
                <a href="#"><i class="fa fa-lg fa-fw fa-cube txt-color-blue"></i> <span class="menu-item-parent">Monthly Hostel Fee</span></a>
                <ul>
                    <li class="">
                        <a href="/ProgressiveHostel/HostelMonthlyFee/HostelMonthlyFeeForm.jsp" title="HostelMonthlyFeeForm"><i class="fa fa-lg fa-fw fa-file-excel-o"></i> <span class="menu-item-parent">Fee Submission Form</span></a> 
                    </li>
                    <li class="">
                        <a href="/ProgressiveHostel/HostelMonthlyFee/StudentDuesList.jsp" title="StudentDuesList"><i class="fa fa-lg fa-fw fa-file-excel-o"></i> <span class="menu-item-parent">Student Dues Report</span></a> 
                    </li>
                </ul>
            </li>
            <li class="top-menu-invisible">
                <a href="#"><i class="fa fa-lg fa-fw fa-gear"></i><span class="menu-item-parent">Setup</span></a>
                <ul>
                    <li class="">
                        <a href="/ProgressiveHostel/Setup/SetClass.jsp" title="SetClass"><i class="fa fa-lg fa-fw fa-gear"></i> <span class="menu-item-parent">Set Class</span></a>
                    </li>
                    <li class="">
                        <a href="/ProgressiveHostel/Setup/SetSection.jsp" title="Dashboard"><i class="fa fa-lg fa-fw fa-gear"></i><span class="menu-item-parent">Set Section</span></a>
                    </li>
                    <li>
                        <a href="/ProgressiveHostel/Setup/SetClassSection.jsp"><i class="fa fa-lg fa-fw fa-gear"></i> <span class="menu-item-parent">Set Class-Section</span></a>
                    </li>
                    <li>
                        <a href="/ProgressiveHostel/Setup/SetOneTimeCharges.jsp"><i class="fa fa-lg fa-fw fa-gear"></i> <span class="menu-item-parent">Set OneTime Charges</span></a>
                    </li>
                    <li>
                        <a href="/ProgressiveHostel/Setup/SetClassHostelMonthlyCharge.jsp"><i class="fa fa-lg fa-fw fa-gear"></i> <span class="menu-item-parent">Set Monthly Charge</span></a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
    <!--    <a href="#ajax/difver.html" class="btn btn-primary nav-demo-btn"><i class="fa fa-info-circle"></i></a>-->
    <span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>
</aside>
<!-- END NAVIGATION -->
<script src="/ProgressiveHostel/assets/js/libs/jquery-3.2.1.min.js"></script>
