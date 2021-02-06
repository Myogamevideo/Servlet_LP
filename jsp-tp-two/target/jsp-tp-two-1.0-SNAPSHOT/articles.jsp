<%-- 
    Document   : articles.jsp
    Created on : 22 janv. 2021, 14:07:12
    Author     : aj-al
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les Articles</title>
    </head>
    <body>
        <h1>Les articles</h1>
        <form method="post">
            <ul>
                <c:forEach items="${articles}" var="article">
                    <li><input type="checkbox" name="articles" value="${article.id}" id="article-${article.id}"><label for="article-${article.id}">${article.id} - ${article.name}</label></li>
                </c:forEach>
            </ul>
            <input type="submit" value="Ajouter au panier" />
        </form>
        <h1>Mon panier :</h1>
        <ul>
            <c:if test="${sessionScope.cart != null}">
                <c:forEach items="${sessionScope.cart}" var="article">
                    <li>${article.id} - ${article.name}</li>
                </c:forEach>
            </c:if>
        </ul>
    </body>
</html>
