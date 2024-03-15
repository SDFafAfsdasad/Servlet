package org.example.servlet;

import org.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //给页面写一句话

        //设置编码
        resp.setContentType("text/html;charset=utf-8");

        //获取request域中共享的user对象
        User user = (User) req.getAttribute("user");

        //输出
        resp.getWriter().write("登陆成功\n"
                +user.getUsername()+"，欢迎！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
