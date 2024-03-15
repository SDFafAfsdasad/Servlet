package org.example.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.example.dao.UserDao;
import org.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LS")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //封装user对象
        User lUser=new User();
        lUser.setUsername(username);
        lUser.setPassword(password);

//        //获取所有请求参数
//        Map<String,String[]> parameterMap = req.getParameterMap();
//
//        //创建User对象
//        User lUser=new User();
//        //使用BeanUtils封装
//        try {
//            BeanUtils.populate(lUser,parameterMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        //调用UserDao的login方法
        UserDao dao=new UserDao();
        User login = dao.login(lUser);

        //判断
        if(login==null){
            //转发
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            req.setAttribute("user",login);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }

    }
}
