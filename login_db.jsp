<%-- 
    Document   : login_db
    Created on : Mar 11, 2020, 11:43:56 AM
    Author     : REHOBOTH
--%>

<%@page import="com.libms.StudentsView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            StudentsView students_view = new StudentsView();
            
            if(students_view.studentExists(email, password)){
                
                int student_id = students_view.getStudentID(email, password);
                
                session.setAttribute("student_logged", student_id);
                
                response.sendRedirect("index.jsp");
            }else{
                session.setAttribute("login_msg", "Invalid username or password");
                response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>
