package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//完成重定向
@WebServlet("/demo11")
public class ServletDemo11 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo11被访问了");

        //访问/demo11，会自动跳转到demo12资源
        //设置状态码为302
        resp.setStatus(302);

        //设置响应头location
//        resp.setHeader("location","/Servlet/demo12");

        //动态获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //简单的重定向
        resp.sendRedirect(contextPath+"/demo12");
    }
}
/*重定向的特点：
*   地址栏发生改变
*   重定向可以访问其它站点（服务器）的资源
*   重定向是两次请求
*   重定向不能使用request对象来共享数据
* */
