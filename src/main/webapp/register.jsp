<%--
  Created by IntelliJ IDEA.
  User: 78618
  Date: 2022/1/27
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="register" method="POST">
    <label>
        Name:
        <input type="text" name="Name">
    </label><br>
    <label>
        E-mail:
        <input type="text" name="email">
    </label><br>
    <label>
        Password:
        <input type="password" name="Password">
    </label><br>
    <label>
        confirm_password:
        <input type="password" name="confirm_password">
    </label><br>
    <input type="reset" value="reset">
    <input type="submit" value="register">
</form>
</body>
</html>
