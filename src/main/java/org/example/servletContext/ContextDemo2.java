package org.example.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextDemo2")
public class ContextDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //定义文件名称
        String filename="a.jpg";

        //获取MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);
    }
}
