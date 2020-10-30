<%-- 
    Document   : login
    Created on : Mar 11, 2020, 7:57:57 AM
    Author     : REHOBOTH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        
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
                    <h3>Login</h3> 
                    <p>Login to your account</p>
                </div>
            </div>
            <div class="row top-margin bottom-margin">
                <div class="col-md-4">
                    
                </div>
                <div class="col-md-4 text-center">
                    <%
                        if(session.getAttribute("login_msg") != null){
                            %>
                            <div class="alert alert-danger">
                                <%
                                    out.print(session.getAttribute("login_msg").toString());
                                %>
                            </div>
                            <%
                            session.removeAttribute("login_msg");
                        }
                    %>
                    <form method="post" action="login_db.jsp">
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="text" class="form-control" name="email"/>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password"/>
                        </div>
                        <input type="submit" value="Login" class="btn btn-success btn-block"/>
                    </form>
                </div>
                <div class="col-md-4">
                    
                </div>
            </div>
        </div>
    </body>
</html>
