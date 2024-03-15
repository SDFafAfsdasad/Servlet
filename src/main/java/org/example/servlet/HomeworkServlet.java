package org.example.servlet;

import org.example.domain.Student;
import org.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String id = req.getParameter("stuId");

        Student student=new Student();
        student.setStuId(id);
        student.setName(name);

        req.setAttribute("student",student);
        req.getRequestDispatcher("/hSuccessServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }


}
