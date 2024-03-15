<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/5
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>time</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        if(cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    flag=true;

                    //设置Cookie的value
                    //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
                    String format = sdf.format(date);

                    //URL编码
                    String encode = URLEncoder.encode(format, "utf-8");
                    cookie.setValue(encode);
                    cookie.setMaxAge(60*60*24*30);  //设置cookie的存活时间为一个月
                    response.addCookie(cookie);

                    String value = cookie.getValue();

                    //URL解码
                    String decode = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>欢迎回来，上次访问时间为"+decode+"</h1>");

                    break;
                }
            }
        }
        if(cookies==null || cookies.length==0 || flag==false){
            //设置Cookie的value
            //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
            String format = sdf.format(date);

            //URL编码
            String encode = URLEncoder.encode(format, "utf-8");

            Cookie cookie=new Cookie("lastTime",encode);
            cookie.setMaxAge(60*60*24*30);  //设置cookie的存活时间为一个月
            response.addCookie(cookie);

            String value = cookie.getValue();

            //URL解码
            String decode = URLDecoder.decode(value, "utf-8");
            cookie.setMaxAge(60*60*24*30);  //设置cookie的存活时间为一个月
            response.addCookie(cookie);
    %>

            response.getWriter().write("<h1>您好，欢迎首次登录</h1>");
<%
        }
%>


</body>
</html>
