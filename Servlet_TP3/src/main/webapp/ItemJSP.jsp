<%-- 
    Document   : ItemJSP
    Created on : Feb 6, 2021, 10:39:58 AM
    Author     : Alexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.alexandre.servlet_tp3.Item"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="ServletItem">
            Description : <input type="text" name="description"/>
            Brand : <input type="text" name="brand"/>
            Price : <input type="number" name="price"/>
            <input type="submit" value="ajouter"/>
        </form>

        <hr>

        <ol>
            <% @SuppressWarnings(
                
                "unchecked")
                List<Item> items = (List< Item>) request.getAttribute("listeItem");
                for (Item item : items) {
            %>
            <li><%= item.getDescription()%></li>
                <% }%>
        </ol>
    </body>
</html>
