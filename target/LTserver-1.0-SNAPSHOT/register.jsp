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
<h1>register</h1>
<form action="RegistServlet" method="post">
    <p>Name:<input type="text" name="Name"></p>
    <p>E-mail:<input type="text" name="email"></p>
    <p>Password:<input type="password" name="Password"></p>
    <p>Repeat password:<input type="password" name="rpwd"></p>
    <p><input type="submit" value="register"> <input type="reset" value="reset"></p>
    <p><a href="login.jsp">go login</a></p><br>
</form>
<% String msg = "welcome!";
msg = (String)request.getAttribute("msg");
out.println(msg);%>
</body>
</html>
