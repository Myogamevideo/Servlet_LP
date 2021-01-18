<%-- 
    Document   : user-form
    Created on : 16 janv. 2021, 11:06:06
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
        <h1>Qui êtes vous ?!</h1>
        <form action="/jsp-tp-two/greetings" method="POST">
            <label for="lastname">Nom :</label>
            <input type="text" name="lastname" id="lastname">
            <br />
            <label for="firstname">Prénom :</label>
            <input type="text" name="firstname" id="firstname">
            <br />
            <input type="submit" value="Valider">
        </form>
    </body>
</html>
