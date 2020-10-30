<%-- 
    Document   : request_book
    Created on : Mar 11, 2020, 9:21:57 PM
    Author     : REHOBOTH
--%>

<%@page import="com.libms.BooksView"%>
<%@page import="com.libms.BooksController"%>
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
            int book_id = Integer.parseInt(request.getParameter("book_id"));
            
            BooksController book_controller = new BooksController();
            BooksView book_view = new BooksView();
            if(!book_view.inBooksRequest(book_id, student_id) && !book_view.inBooks(book_id, student_id)){
                boolean add_book_request = book_controller.addBookRequest(student_id, book_id);
                %>
                    <script type="text/javascript">
                        window.history.back();
                    </script>
                <%
            }else{
                %>
                    <script type="text/javascript">
                        window.history.back();
                    </script>
                <%
            }
        %>
    </body>
</html>
