<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/13/19
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Update Book</h2>
<form:form method="post" action="./edit" modelAttribute="book">
    <p><form:label path="id">ID</form:label>: <form:input path="id" value="${book.id}" readonly="true" /></p>
    <p><form:label path="name">Name</form:label>: <form:input path="name" value="${book.name}" /></p>
    <p><form:label path="author">Author</form:label>: <form:input path="author" value="${book.author}" /></p>
    <p><form:label path="releasedate">Release Date</form:label>: <form:input path="releasedate" value="${book.releasedate}" /></p>
    <p><input type="submit" value="Submit"/> </p>
</form:form>
</body>
</html>
