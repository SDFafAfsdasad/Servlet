package org.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD}) //浏览器直接请求资源时
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //会在服务器启动后，会创建Filter对象，然后调用init方法，用于加载资源
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //每一次请求被拦截资源时，会执行
        //对request对象请求消息增强
        System.out.println("filterDemo2被执行了");

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        //对response对象响应消息增强
    }

    @Override
    public void destroy() {
        //在服务器关闭后，会执行，用于关闭资源
    }
}
