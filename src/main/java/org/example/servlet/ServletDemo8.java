package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo8")
public class ServletDemo8 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get获取请求参数

        //根据参数名称获取参数值
        String username = req.getParameter("username");
        System.out.println("get："+username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post获取请求参数

        //解决tomcat中文乱码问题（设置流的编码）
        req.setCharacterEncoding("utf-8");

        //根据参数名称获取参数值
        String username = req.getParameter("username");
        System.out.println("post："+username);

        //根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            String value=req.getParameter(name);
            System.out.println(name+"："+value);
        }

        //获取所有参数的map集合
        Map<String,String[]> parameterMap = req.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            System.out.println(name);
            for (String value : parameterMap.get(name)) {
                System.out.println(value);
            }
            System.out.println("-------------");
        }
    }
}
