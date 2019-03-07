<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/7/19
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <h1>Danh sach san pham</h1>
    <p><a href="create">Tao moi</a></p>
    <hr/>
    <table>
        <thead>
            <tr>Ma so</tr>
            <tr>Ten</tr>
            <tr>Gia</tr>
            <tr>So luong</tr>
            <tr>Thao tac</tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${listProduct}">
                <tr>
                    <td><c:out value="${row.id}"/></td>
                    <td><c:out value="${row.name}"/></td>
                    <td><c:out value="${row.price}"/></td>
                    <td><c:out value="${row.amount}"/></td>
                    <td>
                        <a href="./details?id=${row.id}">Details</a>
                        <a href="./edit?id=${row.id}">Edit</a>
                        <a href="./delete?id=${row.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
