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
    <title>login</title>
</head>
<body>
<h1>login</h1>
<form action="LoginServlet" method="post">
    <p>Name:<input type="text" name="Name"></p>
    <p>Password:<input type="password" name="Password"></p>
    <p><input type="submit" value="login"> <input type="reset" value="reset"></p>
    <p><a href="register.jsp">go register</a></p>
</form>
</body>
</html>
