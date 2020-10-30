<%-- 
    Document   : change_password_db
    Created on : Mar 11, 2020, 10:14:53 PM
    Author     : REHOBOTH
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.libms.StudentsController"%>
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
            int student_id = Integer.parseInt(request.getParameter("student_id"));
            String old_password = request.getParameter("o_password");
            String new_password = request.getParameter("n_password");
            
            StudentsView students_view = new StudentsView();
            StudentsController students_controller = new StudentsController();
            
            ResultSet student_details = students_view.getStudentDetails(student_id);
            
            String password = student_details.getString("PASSWORD");
            
            if(old_password.equals(password)){
                //students_controller.changeStudentPassword(student_id, new_password);
                session.setAttribute("profile_msg", "Password has being changed");
            }else{
                session.setAttribute("profile_msg", "Incorrect password");
            }
            
            if(student_details != null){
                student_details.close();
            }
            
            response.sendRedirect("profile.jsp");
        %>
    </body>
</html>
