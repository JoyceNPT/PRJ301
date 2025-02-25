<%-- 
    Document   : logout
    Created on : Feb 23, 2025, 8:49:55 PM
    Author     : ngoth
--%>

<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>
