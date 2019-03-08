<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/8/19
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form:form method="post" action="./create" modelAttribute="student">
    <p><form:label path="id">id</form:label>: <form:input path="id"/></p>
    <p><form:label path="name">name</form:label>: <form:input path="name"/></p>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>
