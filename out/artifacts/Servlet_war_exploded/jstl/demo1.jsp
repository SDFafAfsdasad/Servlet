<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/6
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    c:if标签：
        属性：
            test：必须属性，接受boolean表达式
                如果表达式为true，则显示if标签体的内容，否则不显示
                结合el表达式一起使用
        c:if标签没有else情况，需要else情况，可以再定义一个c:if标签
--%>
<c:if test="true">
    <h1>123</h1>
</c:if>
<br>
<%
    //判断request域中的一个list集合是否为空，如果不为null则显式遍历集合
    List list=new ArrayList<>();
    list.add("aa");
    request.setAttribute("list",list);
    request.setAttribute("number",3);
%>
<c:if test="${not empty list}">
    遍历
</c:if>

<c:choose>
    <c:when test="${number==1}">周一</c:when>
    <c:when test="${number==2}">周二</c:when>
    <c:when test="${number==3}">周三</c:when>
    <c:when test="${number==4}">周四</c:when>
</c:choose>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}
</c:forEach>
<c:forEach items="${list}" var="str" varStatus="s">
    ${s.count}
    ${str}
</c:forEach>
</body>
</html>
