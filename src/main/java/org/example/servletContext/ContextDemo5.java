package org.example.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/contextDemo5")
public class ContextDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //通过HttpServlet获取
        ServletContext context = this.getServletContext();

       //获取文件的服务器路径
        String realPath = context.getRealPath("/b.txt"); //web目录下资源访问
//        File file=new File(realPath);
        String pa = context.getRealPath("/WEB-INF/b.txt"); //WEB-INF目录下资源访问
        System.out.println(pa);
        String path = context.getRealPath("/WEB-INF/classes/a.txt"); //src目录下资源访问
        System.out.println(path);
    }
}
