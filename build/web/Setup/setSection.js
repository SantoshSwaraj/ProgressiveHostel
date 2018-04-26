/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function hideMsg() {
    $('#checkSectionAvailMsg').hide();
}

function checkSectionAvailablity(SECTION_NAME) {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            //data is one means already exit;
            //data is zero means new;
            if (data == 1)
            {
                $("#checkSectionAvailMsg").show();
                document.getElementById("btn").disabled = true;
            }
            if (data == 0)
            {
                $("#checkSectionAvailMsg").hide();
                document.getElementById("btn").disabled = false;
            }
        }
    }
    xmlhttp.open("POST", "/ProgressiveHostel/CheckSectionAvailablity?SECTION_NAME=" + SECTION_NAME, true);
    xmlhttp.send();
}

function getSections() {
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
    xmlhttp.open("POST", "/ProgressiveHostel/GetSections", true);
    xmlhttp.send();
}

