package org.example.filter;

//登录验证的过滤器

import org.example.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //强制转换
        HttpServletRequest request=(HttpServletRequest) servletRequest;

        //获取资源的请求路径
        String requestURI = request.getRequestURI();
        //判断是否包含登录相关资源路径，要注意排除掉css/js/图片/验证码等资源
        if(requestURI.contains("/login.jsp") || requestURI.contains("/loginServlet") || requestURI.contains("/css/") || requestURI.contains("/js/")){
            //包含，放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            //不包含，验证用户是否登录
            //从session中获取user
            User user =(User) request.getSession().getAttribute("user");
            if(user !=null){
                //登陆了
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                //跳转登录页面
                request.setAttribute("login_msg","尚未登录，请先登录");
                request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
