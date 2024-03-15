package org.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*") //表示访问所有资源之前，都会执行该过滤器
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //会在服务器启动后，会创建Filter对象，然后调用init方法，用于加载资源
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //每一次请求被拦截资源时，会执行
        //对request对象请求消息增强
        System.out.println("filterDemo1被执行了");

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        //对response对象响应消息增强
    }

    @Override
    public void destroy() {
        //在服务器关闭后，会执行，用于关闭资源
    }
}
/*
* 过滤器链（配置多个过滤器）
*   执行顺序：如果有两个过滤器：过滤器1和过滤器2
*       过滤器1
*       过滤器2
*       资源执行
*       过滤器2
*       过滤器1
*   过滤器先后顺序：
*       注解配置：按照类名的字符串比较规则比较，值小的先执行
*           如：aFilter和bFilter，则aFilter先执行
*       web.xml配置：
*           <filter-mapping>定义在上面的先执行
* */