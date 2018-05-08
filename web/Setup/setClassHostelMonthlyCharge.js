/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function hideMsg() {
    $('#checkMsg').hide();
}

function checkClassHostelMonthlyFeeAvailablity() {
    var xmlhttp;
    var CLASS_ID = document.getElementById("CLASS_ID").value;
    var FEE = document.getElementById("FEE").value;
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
                $("#checkMsg").show();
                document.getElementById("btn").disabled = true;
            }
            if (data == 0)
            {
                $("#checkMsg").hide();
                document.getElementById("btn").disabled = false;
            }
        }
    }
    xmlhttp.open("POST", "/ProgressiveHostel/CheckClassHostelMonthlyFeeAvailablity?CLASS_ID=" + CLASS_ID + "&FEE=" + FEE, true);
    xmlhttp.send();

}

function getClassHostelMonthlyCharges() {
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
    xmlhttp.open("POST", "/ProgressiveHostel/GetClassHostelMonthlyCharges", true);
    xmlhttp.send();
}

