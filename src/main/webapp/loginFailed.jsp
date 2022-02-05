<%--
  Created by IntelliJ IDEA.
  User: 78618
  Date: 2022/2/2
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>login fail!</title>
</head>
<body>
<h1>login fail!</h1><br>
<% String msg;
  msg = (String)request.getAttribute("msg");
  out.println(msg);%><br>
<p><a href="login.jsp">login again</a></p>
</body>
</html>
