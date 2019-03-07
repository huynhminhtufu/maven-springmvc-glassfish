<%--
  Created by IntelliJ IDEA.
  User: tuhuynh
  Date: 3/6/19
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Đăng ký</h1>
<form action="./getFromPOST" method="post">
    <table>
        <tr>
            <td>Code</td>
            <td><input name="id" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input name="name" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Đăng ký"/> </td>
        </tr>
    </table>
</form>
</body>
</html>
