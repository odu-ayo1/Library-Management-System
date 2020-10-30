<%-- 
    Document   : search
    Created on : Mar 11, 2020, 7:58:38 AM
    Author     : REHOBOTH
--%>

<%@page import="com.libms.CategoriesView"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.libms.BooksView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Books</title>
        
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
            <div class="row top-margin">
                <div class="col-md-12 text-center">
                    <h3>Search Result</h3> 
                </div>
            </div>
            <div class="row top-margin bottom-margin">
                <%     
                    String category = request.getParameter("category");
                    String search = request.getParameter("search");
                    
                    BooksView books_view = new BooksView();
                    CategoriesView categories_view = new CategoriesView();
                    
                    ResultSet all_books = books_view.SearchBook(search);
                    ResultSet book_categories = null;
                    ResultSet categories_details = null;
                    
                    if("all".equals(category)){
                        
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
                                            <%
                                                if(session.getAttribute("student_logged") == null){
                                                    %>
                                                        <a href="login.jsp" class="btn btn-success">Login to download</a>
                                                    <%
                                                }else{
                                                    int student_id = Integer.parseInt(session.getAttribute("student_logged").toString());
                                                    if(books_view.inBooks(book_id, student_id)){
                                                        %>
                                                            <a href="<%= book_path%>" class="btn btn-success">Download</a>
                                                        <%
                                                    }else if(books_view.inBooksRequest(book_id, student_id)){
                                                        %>
                                                            <a href="#" class="btn btn-success">Book Requested</a>
                                                        <%
                                                    }else{
                                                        %>
                                                            <a href="request_book.jsp?student_id=<%= student_id%>&book_id=<%= book_id%>" class="btn btn-success">Request Book</a>
                                                        <%
                                                    }
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            <%
                        }

                    }else{
                        int category_id = Integer.parseInt(category);
                        
                        while(all_books.next()){
                        int book_id = all_books.getInt("BOOKID");
                        String book_path = all_books.getString("BOOKPATH");
                        String image_path = all_books.getString("THUMBNAILPATH");
                        String title = all_books.getString("TITLE");
                        String author = all_books.getString("AUTHOR");
                        String description = all_books.getString("DESCRIPTION");
                        
                        book_categories = books_view.viewBookCategories(book_id);
                        if(books_view.inCategory(book_id, category_id)){
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
                                            <%
                                                if(session.getAttribute("student_logged") == null){
                                                    %>
                                                        <a href="login.jsp" class="btn btn-success">Login to download</a>
                                                    <%
                                                }else{
                                                    int student_id = Integer.parseInt(session.getAttribute("student_logged").toString());
                                                    if(books_view.inBooks(book_id, student_id)){
                                                        %>
                                                            <a href="<%= book_path%>" class="btn btn-success">Download</a>
                                                        <%
                                                    }else if(books_view.inBooksRequest(book_id, student_id)){
                                                        %>
                                                            <a href="#" class="btn btn-success">Book Requested</a>
                                                        <%
                                                    }else{
                                                        %>
                                                            <a href="request_book.jsp?student_id=<%= student_id%>&book_id=<%= book_id%>" class="btn btn-success">Request Book</a>
                                                        <%
                                                    }
                                                }
                                            %>
                                            
                                        </div>
                                    </div>
                                </div>
                            <%
                        }
                    }
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
        </div>
    </body>
</html>
