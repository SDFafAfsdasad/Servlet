<%@ page import="org.example.domain.User" %>
<%@ page import="org.example.domain.People" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/6
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    People people=new People();
    people.setName("张三");
    people.setAge(18);
    people.setBirthday(new Date());

    request.setAttribute("people",people);
%>

<h3>使用el获取对象中的值</h3>
${requestScope.people}
</body>
</html>
