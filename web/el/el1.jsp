<%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/5
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>empty运算符</h4>
<%
    String str="abc";
    request.setAttribute("str",str);
%>
    <h5>判断str的长度是否为0或者为null</h5>
${not empty str}
<h5>动态获取虚拟目录</h5>
${pageContext.request.contextPath}
</body>
</html>
