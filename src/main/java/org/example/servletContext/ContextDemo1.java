package org.example.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextDemo1")
public class ContextDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //通过request对象获取（servlet版本需要高一些才会有这个方法）
        ServletContext contetx1 = req.getServletContext();

        //通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println(context2==contetx1);
    }
}
/*
* ServletContext
* 概念：代表整个web应用，可以和程序的容器（服务器）来通信
* 获取：
*   通过request对象获取：request.getServletContext()
*   通过HttpServlet获取：this.getServletContext()
* 功能：
*   获取MIME类型
*       MIME类型：在互联网通信过程中定义的一种文件数据类型
*           格式：大类型/小类型  text/html   image/jpeg
*           获取：String getMimeType(String filename)
*
*   域对象：共享数据
*        void setAttribute(String name,Object obj) : 存储数据
 *       Object getAttribute(String name) : 通过键获取值
 *       void removeAttribute(String name) : 通过键移除键值对
 *      ServletContext对象范围：所有用户所有请求的数据
 *
*   获取文件的真实（服务器）路径
*
* */