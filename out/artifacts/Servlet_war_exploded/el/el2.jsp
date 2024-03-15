<%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/6
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //在域中存储数据
    request.setAttribute("name","张三");
    session.setAttribute("age",12);
%>
<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
</body>
</html>
