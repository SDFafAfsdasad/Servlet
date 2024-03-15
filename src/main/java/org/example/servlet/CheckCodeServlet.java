package org.example.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int width=100;
        int height=50;

        //创建一个对象，在内存中的图片（验证码图片对象）
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //美化图片
        //填充背景色
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.PINK); //设置画笔颜色
        graphics.fillRect(0,0,width-1,height-1);
        //画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width,height);

        //写验证码
        graphics.drawString("a",20,25);

        //画干扰线
        graphics.setColor(Color.green);
        graphics.drawLine(0,0,20,55);

        //将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
