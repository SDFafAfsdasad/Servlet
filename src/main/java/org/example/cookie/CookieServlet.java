package org.example.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

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
            response.getWriter().write("<h1>您好，欢迎首次登录</h1>");

        }
    }
}
