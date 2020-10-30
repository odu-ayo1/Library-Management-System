<%-- 
    Document   : logout
    Created on : Mar 11, 2020, 1:35:04 PM
    Author     : REHOBOTH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.removeAttribute("student_logged");
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
