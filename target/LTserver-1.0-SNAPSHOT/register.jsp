<%--
  Created by IntelliJ IDEA.
  User: 78618
  Date: 2022/1/27
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="register" method="POST">
    name:<input type="text" name="name"><br>
    E-mail:<input type="text" name="email"><br>
    password:<input type="password" name="password"><br>
    confirm_password:<input type="password" name="confirm_password"><br>
    <input type="reset" value="reset">
    <input type="submit" value="register">
</form>
</body>
</html>
