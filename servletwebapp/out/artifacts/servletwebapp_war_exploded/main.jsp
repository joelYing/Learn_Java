<%--
  Created by IntelliJ IDEA.
  User: joel
  Date: 2019/1/10
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<% String name=request.getParameter("username"); %>
欢迎用户：
<%=name %>
您已经登录成功，可以尽情浏览本网站

</body>
</html>