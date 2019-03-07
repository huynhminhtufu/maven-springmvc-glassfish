<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/7/19
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form:form method="post" action="./edit" modelAttribute="product">
    <table>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id" value="${product.id}" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name"  value="${product.name}"/></td>
        </tr>
        <tr>
            <td><form:label path="price">price</form:label></td>
            <td><form:input path="price"  value="${product.price}"/></td>
        </tr>
        <tr>
            <td><form:label path="amount">amount</form:label></td>
            <td><form:input path="amount"  value="${product.amount}"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
