<%-- 
    Document   : aside
    Created on : 19 Apr, 2018, 12:36:51 PM
    Author     : Santosh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- #NAVIGATION -->
<!-- Left panel : Navigation area -->
<!-- Note: This width of the aside area can be adjusted through LESS/SASS variables -->

<aside id="left-panel">

    <!-- User info -->
    <div class="login-info">
        <span> <!-- User image size is adjusted inside CSS, it should stay as is --> 

            <a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
                <img src="/ProgressiveHostel/assets/img/avatars/sunny.png" alt="me" class="online" /> 
                <span>
                    Santosh Kushwaha 
                </span>
                <i class="fa fa-angle-down"></i>
            </a> 

        </span>
    </div>
    <nav>
        <ul id="MainMenu">
            <li class="">
                <a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Dashboard</span></a>
            </li>
            <li class="">
                <a href="#" title="New Student Admission"><i class="fa fa-lg fa-fw fa-cube txt-color-blue"></i> <span class="menu-item-parent"> New Addmission</span></a>
                <ul>
                    <li class="">
                        <a href="#" title="Add New Student"><i class="fa fa-cube"></i> <span class="menu-item-parent"> Add New Student</span></a>
                    </li>
                    <li class="">
                        <a href="#" title="View All Student"><i class="fa fa-lg fa-fw fa-picture-o"></i>&nbsp;<span class="menu-item-parent"> View All Student</span></a>
                    </li>
                </ul>	
            </li>
            <li class="top-menu-invisible">
                <a href="#"><i class="fa fa-lg fa-fw fa-cube txt-color-blue"></i> <span class="menu-item-parent">Monthly Hostel Fee</span></a>
                <ul>
                    <li class="">
                        <a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa-gear"></i> <span class="menu-item-parent">App Layouts</span></a>
                    </li>
                    <li class="">
                        <a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa-picture-o"></i> <span class="menu-item-parent">Prebuilt Skins</span></a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-stack-overflow"></i> App Variations</a>
                    </li>
                    <li>
                        <a href="ajax/applayout.html"><i class="fa fa-cube"></i> App Settings</a>
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
                        <a href="/ProgressiveHostel/Setup/SetMonthlyCharge.jsp"><i class="fa fa-lg fa-fw fa-gear"></i> <span class="menu-item-parent">Set Monthly Charge</span></a>
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
