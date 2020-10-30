<%-- 
    Document   : Profile
    Created on : Mar 11, 2020, 9:48:37 PM
    Author     : REHOBOTH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
        
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
                    <h3>Profile</h3> 
                    <p>Change Your Password</p>
                </div>
            </div>
            <div class="row top-margin bottom-margin">
                <div class="col-md-4">
                    
                </div>
                <div class="col-md-4 text-center">
                    <%
                        if(session.getAttribute("profile_msg") != null){
                            %>
                            <div class="alert alert-danger">
                                <%
                                    out.print(session.getAttribute("profile_msg").toString());
                                %>
                            </div>
                            <%
                            session.removeAttribute("profile_msg");
                        }
                    %>
                    <form method="post" action="change_password_db.jsp">
                        <input type="hidden" name="student_id" value="<% out.print(Integer.parseInt(session.getAttribute("student_logged").toString())); %>"/>
                        <div class="form-group">
                            <label>Old Password</label>
                            <input type="password" class="form-control" name="o_password"/>
                        </div>
                        <div class="form-group">
                            <label>New Password</label>
                            <input type="password" class="form-control" name="n_password"/>
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
