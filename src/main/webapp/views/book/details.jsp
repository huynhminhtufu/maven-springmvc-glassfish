<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/13/19
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Details</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Book Details</h2>
<p>ID: ${book.id}</p>
<p>Name: ${book.name}</p>
<p>Author: ${book.author}</p>
<p>Release Date: ${book.releasedate}</p>
</body>
</html>
