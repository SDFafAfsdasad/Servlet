package org.example.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化方法，在Servlet被创建时执行，只会执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
        //问题：多个用户同时访问时，可能存在线程安全问题
        //解决：尽量不要在Servlet中定义成员变量，即使定义了成员变量，也不要修改值
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //提供服务的方法，每一次被访问时执行
        System.out.println("hello servlet...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        //销毁，在服务器正常关闭时执行，执行一次
    }
}
