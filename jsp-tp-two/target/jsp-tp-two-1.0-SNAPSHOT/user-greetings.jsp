<%-- 
    Document   : user-greetings
    Created on : 16 janv. 2021, 11:17:41
    Author     : aj-al
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ugly way :</h1>
        <h2>Bonjour, <%= request.getParameter("firstname") + " " + request.getParameter("lastname") %> !</h2>
        <h1>Proper way :</h1>
        <h2>Bonjour,  ${param.firstname} ${param.lastname} !</h2>
    </body>
</html>
