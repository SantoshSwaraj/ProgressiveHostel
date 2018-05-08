/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkNumber(evt) {
    var iKeyCode = (evt.which) ? evt.which : evt.keyCode;
    if (iKeyCode >= 47 && iKeyCode <= 57) {
        return true;
    }
    else {
        alert("Please Enter Digits Only");
        return false;
    }
}

function checkAlpha(evt)
{
    var keyCode = (evt.which) ? evt.which : evt.keyCode;
    if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32) {
        alert("Please Enter Alphabets Only");
        return false;
    }
    return true;

}

function validateEmail(emailField) {
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

    if (reg.test(emailField.value) == false)
    {
        alert('Invalid Email Address');
        document.getElementById("emailid").value = "";
        return false;
    }
    return true;
}

function checkEmailAvailablity(EMAIL) {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            //data is zero means already exit;
            //data is one means new;
            if (data == 0)
            {
                $("#emailvalmsg").show();
                document.getElementById("btn").disabled = true;
            }
            if (data == 1)
            {
                $("#emailvalmsg").hide();
                document.getElementById("btn").disabled = false;
            }
        }
    }
    xmlhttp.open("POST", "/UnificationGrowthNidhi/CheckEmailAvailability?EMAIL=" + EMAIL, true);
    xmlhttp.send();
}

function checkMobileAvailablity(MOBILE) {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            //data is zero means already exit;
            //data is one means new;
            if (data == 0)
            {
                $("#mobilevalmsg").show();
                document.getElementById("btn").disabled = true;
            }
            if (data == 1)
            {
                $("#mobilevalmsg").hide();
                document.getElementById("btn").disabled = false;
            }
        }
    }
    xmlhttp.open("POST", "/UnificationGrowthNidhi/CheckMobileAvailability?MOBILE=" + MOBILE, true);
    xmlhttp.send();
}

function checkUserNameAvailablity(USERNAME) {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var data = xmlhttp.responseText;
            //data is zero means already exit;
            //data is one means new;
            if (data == 0)
            {
                $("#uservalmsg").show();
                document.getElementById("btn").disabled = true;
            }
            if (data == 1)
            {
                $("#uservalmsg").hide();
                document.getElementById("btn").disabled = false;
            }
        }
    }
    xmlhttp.open("POST", "/UnificationGrowthNidhi/CheckUserNameAvailability?USERNAME=" + USERNAME, true);
    xmlhttp.send();
}

function hideEmailValMsgs() {
    $("#emailvalmsg").hide();
}

function hideMobileValMsgs() {
    $("#mobilevalmsg").hide();
}

function hideUsernameValMsgs() {
    $("#uservalmsg").hide();
}



