package org.example.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo4")
public class ServletDemo4 extends GenericServlet {
    //GenericServlet将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo4");
    }
}
