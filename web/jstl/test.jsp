<%@ page import="java.util.List" %>
<%@ page import="org.example.domain.People" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/6
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<People> list=new ArrayList<>();
    People p1=new People("张三",12,new Date());
    People p2=new People("李四",12,new Date());
    People p3=new People("王五",12,new Date());
    list.add(p1);
    list.add(p2);
    list.add(p3);
    request.setAttribute("list",list);
%>
<%
    Object msg = request.getAttribute("msg");
    System.out.println(msg);
%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${list}" var="p" varStatus="s">
        <tr>
            <th>${s.count}</th>
            <th>${p.name}</th>
            <th>${p.age}</th>
            <th>${p.birthday}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
