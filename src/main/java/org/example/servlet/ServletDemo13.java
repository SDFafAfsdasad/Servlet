package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/demo13")
public class ServletDemo13 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo13 被访问了...");

        //解决办法：在获取流对象之前，设置默认编码
        resp.setCharacterEncoding("utf-8");

        //告诉浏览器，服务器发送的消息体的编码，建议浏览器使用该编码解码
        //resp.setHeader("content-type","text/html;charset=utf-8");

        //简单的方法设置编码
        resp.setContentType("text/html;charset=utf-8");

        //获取字符输出流
        PrintWriter writer = resp.getWriter();


        //输出数据
        //此时出现中文乱码问题（原因：编解码使用的字符集不一致）
        writer.write("<h1>你好 demo13</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
