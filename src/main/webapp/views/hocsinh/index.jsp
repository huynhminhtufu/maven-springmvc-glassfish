<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/8/19
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach hoc sinh</title>
</head>
<body>
<h1>Danh sach hoc sinh</h1>
<a href="/hocsinh/create">Tao moi</a>
    <table>
        <thead>
            <thead>
                <td>Ma so</td>
                <td>Ten</td>
                <td>Thao tac</td>
            </thead>
        </thead>
        <tbody>
            <c:forEach var="row" items="${listHocSinh}">
                <tr>
                    <td><c:out value="${row.id}"/></td>
                    <td><c:out value="${row.name}"/></td>
                    <td>
                        <a href="/hocsinh/details?id=${row.id}">Details</a>
                        <a href="/hocsinh/edit?id=${row.id}">Edit</a>
                        <a href="/hocsinh/delete?id=${row.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
