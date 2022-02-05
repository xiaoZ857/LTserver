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
<h1>register</h1>
<form action="RegistServlet" method="post">
    <p>Name:<label>
        <input type="text" name="name">
    </label></p>
    <p>E-mail:<label>
        <input type="text" name="email">
    </label></p>
    <p>Password:<label>
        <input type="password" name="password">
    </label></p>
    <p>Repeat password:<label>
        <input type="password" name="rpwd">
    </label></p>
    <p><input type="submit" value="register"> <input type="reset" value="reset"></p>
    <p><a href="login.jsp">go login</a></p><br>
</form>
<% String msg;
    msg = (String)request.getAttribute("msg");
out.println(msg);%>
</body>
</html>
