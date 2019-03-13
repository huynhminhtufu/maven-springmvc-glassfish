<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/13/19
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create book</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Create book</h2>
<form:form method="post" action="./create" modelAttribute="book">
    <form:input path="id" readonly="true" hidden="true" />
    <p><form:label path="name">Name</form:label>: <form:input path="name" /></p>
    <p><form:label path="author">Author</form:label>: <form:input path="author" /></p>
    <p><form:label path="releasedate">Release Date</form:label>: <form:input path="releasedate" /></p>
    <p><input type="submit" value="Submit"/> </p>
</form:form>
</body>
</html>
