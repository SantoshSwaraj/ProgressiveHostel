<%
    try {
        if (session.getAttribute("wmsg") == null || session.getAttribute("wmsg") == " " || session.getAttribute("wmsg").toString().equals("")) {
%> 
<div id="wmsg">
    <%session.setAttribute("wmsg", " ");%>  
</div> 
<%
} else {%> 
<div id="wmsg" style="color: black; font-size: 13px; font-weight: 900; background-color: #ff000063; padding: 8px; margin-left: 12px; margin-bottom: 12px;">
    <strong>
        Error ! <%=session.getAttribute("wmsg")%>
    </strong>
    <%session.setAttribute("wmsg", " ");%> 
</div> 
<%}
    } catch (Exception e) {

    }
%> 






<%
    try {
        if (session.getAttribute("msg") == null || session.getAttribute("msg") == " " || session.getAttribute("msg").toString().equals("")) {
%> 
<div id="msg">
    <%session.setAttribute("msg", " ");%> 
</div> 
<%
} else {%> 
<div id="msg" style="color: black; font-size: 13px; font-weight: 900; background-color: #a6f3b3; padding: 8px; margin-left: 12px; margin-bottom: 12px;">
    <strong>
        Success ! <%=session.getAttribute("msg")%>
    </strong>
        <%session.setAttribute("msg", " ");%> 
</div> 
<%}
    } catch (Exception e) {

    }
%> 
