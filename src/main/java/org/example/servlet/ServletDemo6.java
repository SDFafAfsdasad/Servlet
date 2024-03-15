package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo6")
public class ServletDemo6 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取请求方式
////        String method = req.getMethod();
////        System.out.println(method);
////
////        //获取虚拟目录
////        String contextPath = req.getContextPath();
////        System.out.println(contextPath);
////
////        //获取Servlet路径
////        String servletPath = req.getServletPath();
////        System.out.println(servletPath);
////
////        //获取GET请求的请求参数
////        String queryString = req.getQueryString();
////        System.out.println(queryString);
////
////        //获取请求URI
////        String requestURI = req.getRequestURI();
////        StringBuffer requestURL = req.getRequestURL();
////        System.out.println(requestURL);
////        System.out.println(requestURI);
////
////        //获取协议及版本
////        String protocol = req.getProtocol();
////        System.out.println(protocol);
////
////        //获取客户机的IP
////        String remoteAddr = req.getRemoteAddr();
////        System.out.println(remoteAddr);


//        Enumeration<String> headerNames = req.getHeaderNames();
//        //遍历
//        while (headerNames.hasMoreElements()){
//            String name = headerNames.nextElement();
//            //根据名称获取请求头的值
//            String header = req.getHeader(name);
//            System.out.println("header="+header);
//        }
        //演示获取请求头数据：user-agent
        String header = req.getHeader("user-agent");
        //判断agent的浏览器的版本
        if(header.contains("Chrome")){
            System.out.println("谷歌");
        }else {
            System.out.println("其他");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
