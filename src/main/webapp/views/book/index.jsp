<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/11/19
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Index</title>
</head>
<body>
<h2>Book List</h2>
<a href="./create">Create new book</a>
<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>RealeaseDate</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${listBook}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.author}"/></td>
            <td><c:out value="${row.releasedate}"/></td>
            <td>
                <a href="/book/details?id=${row.id}">Details</a>
                <a href="/book/edit?id=${row.id}">Edit</a>
                <a href="/book/delete?id=${row.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
