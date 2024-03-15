<%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/5
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>home</h2>
<%
    pageContext.setAttribute("msg","hello");
%>
<%=pageContext.getAttribute("msg")%>
</body>
</html>
