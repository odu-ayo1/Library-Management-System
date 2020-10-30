<%-- 
    Document   : contact_db
    Created on : Mar 11, 2020, 9:48:14 PM
    Author     : REHOBOTH
--%>

<%@page import="com.libms.StudentsController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String full_name = request.getParameter("full_name");
            String email = request.getParameter("email");
            String subject = request.getParameter("subject");
            String body = request.getParameter("body");
            
            StudentsController students_controller = new StudentsController();
            if(!students_controller.addContact(full_name, email, subject, body)){
                session.setAttribute("contact_msg", "Message sent");
                response.sendRedirect("contact.jsp");
            }else{
                session.setAttribute("contact_msg", "Could not sent message");
                response.sendRedirect("contact.jsp");
            }
        %>
    </body>
</html>
