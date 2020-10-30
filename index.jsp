<%-- 
    Document   : index
    Created on : Mar 9, 2020, 10:48:02 AM
    Author     : REHOBOTH
--%>

<%@page import="com.libms.CategoriesView"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.libms.BooksView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        
        <jsp:include page="includes/meta.jsp" />
        
        <jsp:include page="includes/resources.jsp" />
        
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <div class="container">
            <jsp:include page="includes/header.jsp" />
            <div class="row">
                <div class="col-md-3 top-margin">
                    <jsp:include page="includes/sidebar.jsp" />
                </div>
                <div class="col-md-9 top-margin">
                    <jsp:include page="includes/navbar.jsp" />
                    <div class="row top-margin">
                        <div class="col-md-12">
                            <img src="images/banner_1.jpg" style="width: 100%; height: 500px;"/>
                        </div>
                    </div>
                </div>
            </div>
            <%
                if(session.getAttribute("student_logged") == null){
                    %>
                        <div class="row top-margin">
                            <div class="col-md-12 text-center">
                                <h3>All Books</h3> 
                            </div>
                        </div>
                            <div class="row top-margin bottom-margin">
                                <%
                                    BooksView books_view = new BooksView();
                                    CategoriesView categories_view = new CategoriesView();

                                    ResultSet all_books = books_view.viewBooks();
                                    ResultSet book_categories = null;
                                    ResultSet categories_details = null;

                                    while(all_books.next()){
                                        int book_id = all_books.getInt("BOOKID");
                                        String book_path = all_books.getString("BOOKPATH");
                                        String image_path = all_books.getString("THUMBNAILPATH");
                                        String title = all_books.getString("TITLE");
                                        String author = all_books.getString("AUTHOR");
                                        String description = all_books.getString("DESCRIPTION");
                                        book_categories = books_view.viewBookCategories(book_id);
                                        %>
                                            <div class="col-md-4">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <img src="<%= image_path%>" width="100%"/>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <h4><%= title%></h4>
                                                        <p>Categories: 
                                                            <%
                                                                while(book_categories.next()){
                                                                    int book_category_id = book_categories.getInt("CAtEGORYID");
                                                                    categories_details = categories_view.getCategoryDetails(book_category_id);
                                                                    String book_category_name = categories_details.getString("CATEGORYNAME");
                                                                    %>
                                                                        <span class="badge"><%= book_category_name%></span>
                                                                    <%
                                                                }
                                                            %></p>
                                                        <p><%= description%></p>
                                                        <p>Author: <%= author%></p>
                                                        <a href="login.jsp" class="btn btn-success">Login to download</a>
                                                    </div>
                                                </div>
                                            </div>
                                        <%
                                    }
                                %>
                                <%
                                    if(all_books != null){
                                        all_books.close();
                                    }

                                    if(categories_details != null){
                                        categories_details.close();
                                    }

                                    if(book_categories != null){
                                        book_categories.close();
                                    }
                                %>
                            </div>
                    <%
                }else{
                    %>
                        <div class="row top-margin">
                            <div class="col-md-12 text-center">
                                <h3>My Books</h3> 
                            </div>
                        </div>
                        <div class="row top-margin bottom-margin">
                            <%
                                int student_id = Integer.parseInt(session.getAttribute("student_logged").toString());
                                   
                                BooksView books_view = new BooksView();
                                CategoriesView categories_view = new CategoriesView();

                                ResultSet student_books_id = books_view.viewStudentBooks(student_id);
                                ResultSet book_details = null;
                                ResultSet book_categories = null;
                                ResultSet categories_details = null;
                                    
                                while(student_books_id.next()){
                                    int book_id = student_books_id.getInt("BOOKID");
                                        
                                    book_details = books_view.getBookDetails(book_id);
                                    String book_path = book_details.getString("BOOKPATH");
                                    String image_path = book_details.getString("THUMBNAILPATH");
                                    String title = book_details.getString("TITLE");
                                    String author = book_details.getString("AUTHOR");
                                    String description = book_details.getString("DESCRIPTION");
                                    book_categories = books_view.viewBookCategories(book_id);
                                     
                                    %>
                                        <div class="col-md-4">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <img src="<%= image_path%>" width="100%"/>
                                                </div>
                                                <div class="col-md-6">
                                                    <h4><%= title%></h4>
                                                    <p>Categories: 
                                                        <%
                                                            while(book_categories.next()){
                                                                int book_category_id = book_categories.getInt("CAtEGORYID");
                                                                categories_details = categories_view.getCategoryDetails(book_category_id);
                                                                String book_category_name = categories_details.getString("CATEGORYNAME");
                                                                %>
                                                                    <span class="badge"><%= book_category_name%></span>
                                                                <%
                                                            }
                                                        %></p>
                                                    <p><%= description%></p>
                                                    <p>Author: <%= author%></p>
                                                    <a href="<%= book_path%>" class="btn btn-success">Download</a>
                                                </div>
                                            </div>
                                        </div>
                                    <%
                                }
                            %>
                            <%
                                if(student_books_id != null){
                                    student_books_id.close();
                                }
                                
                                if(book_details != null){
                                    book_details.close();
                                }

                                if(categories_details != null){
                                    categories_details.close();
                                }

                                if(book_categories != null){
                                    book_categories.close();
                                }
                            %>
                        </div>
                    <%
                }
            %>
        </div>
    </body>
</html>
