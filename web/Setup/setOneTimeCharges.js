/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function hideMsg() {
    $('#checkChargeAvailMsg').hide();
}

function checkOneTimeChargeAvailablity() {
    var xmlhttp;
    var CHARGE_NAME = document.getElementById("CHARGE_NAME").value;
    var CHARGE_AMOUNT = document.getElementById("CHARGE_AMOUNT").value;
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
                $("#checkChargeAvailMsg").show();
                document.getElementById("btn").disabled = true;
            }
            if (data == 0)
            {
                $("#checkChargeAvailMsg").hide();
                document.getElementById("btn").disabled = false;
            }
        }
    }
    xmlhttp.open("POST", "/ProgressiveHostel/CheckOneTimeChargeAvailablity?CHARGE_NAME=" + CHARGE_NAME + "&CHARGE_AMOUNT=" + CHARGE_AMOUNT, true);
    xmlhttp.send();
}

function getOneTimeCharges() {
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
    xmlhttp.open("POST", "/ProgressiveHostel/GetOneTimeCharges", true);
    xmlhttp.send();
}

