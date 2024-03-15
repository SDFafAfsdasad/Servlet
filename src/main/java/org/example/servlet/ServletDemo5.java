package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/demo5")
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post ");
    }
}
/*
* request功能：
*   1.获取请求行数据
*       获取请求方式：String getMethod()
*       获取虚拟目录：String getContextPath()
*       获取Servlet路径：String getServletPath()
*       获取get方式请求参数：String getQueryString()
*       获取请求的URI：String getRequestURI()
*       获取请求的URL：StringBuffer getRequestURI()
*   2.获取请求头数据
*       String getHeader(String name)   通过请求头的名称获取请求头的值
*
*       Enumeration<String> getHeaderNames() 获取所有的请求头名称
*   3.获取请求体数据
*   其他功能：
*
*
* 请求转发：一种在服务器内部的资源跳转方式
*       步骤：
*           1.通过request对象获取请求转发器对象： RequestDispatcher getRequestDispatcher(String path)
*           2.使用RequestDispatcher对象来进行转发：forward(ServletRequest req,ServletResponse rep)
*       特点：
*           1.浏览器地址栏路径不发生变化
*           2.只能转发到当前服务器内部资源中
*           3.转发是一次请求
* 数据共享：
*       域对象：一个有作用范围i的对象，可以在范围内共享数据
*       request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
*       方法：
*           void setAttribute(String name,Object obj) : 存储数据
*           Object getAttribute(String name) : 通过键获取值
*           void removeAttribute(String name) : 通过键移除键值对
*
*
* */