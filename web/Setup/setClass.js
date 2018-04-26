/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function hideMsg() {
    $('#checkClassAvailMsg').hide();
}

function checkClassAvailablity(CLASS_NAME) {
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
                $("#checkClassAvailMsg").show();
                document.getElementById("btn").disabled = true;
            }
            if (data == 0)
            {
                $("#checkClassAvailMsg").hide();
                document.getElementById("btn").disabled = false;
            }
        }
    }
    xmlhttp.open("POST", "/ProgressiveHostel/CheckClassAvailablity?CLASS_NAME=" + CLASS_NAME, true);
    xmlhttp.send();
}

function getClasses() {
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
    xmlhttp.open("POST", "/ProgressiveHostel/GetClasses", true);
    xmlhttp.send();
}


