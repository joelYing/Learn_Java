<%--
  Created by IntelliJ IDEA.
  User: joel
  Date: 2019/1/10
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="http://localhost:8080/servletwebapp/main.jsp" method="POST">
    用户：<input type="text" name="username" /><br/>
    密码：<input type="password" name="password" /><br/>
    <input type="submit" value="登录" />
</form>

</body>
</html>
