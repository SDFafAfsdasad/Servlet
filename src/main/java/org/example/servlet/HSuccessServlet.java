package org.example.servlet;

import org.example.domain.Student;
import org.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HSuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取时间
        Date currentDate = new Date();

        //给页面写一句话

        //设置编码
        resp.setContentType("text/html;charset=utf-8");

        //获取request域中共享的user对象
        Student stu = (Student) req.getAttribute("student");

        //输出
        resp.getWriter().write("ID："+stu.getStuId()+"<br>"
                                +"Name："+stu.getName()+"<br>"
                                +"Date and Time: " + currentDate);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
