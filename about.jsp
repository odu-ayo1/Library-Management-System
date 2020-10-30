<%-- 
    Document   : about
    Created on : Mar 11, 2020, 7:57:29 AM
    Author     : REHOBOTH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>About</title>
        
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
                    <h3>About Us</h3> 
                </div>
            </div>
        </div>
    </body>
</html>
