package org.example.servletContext;


import org.example.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取context对象
        ServletContext servletContext = this.getServletContext();

        //获取文件名称
        String filename = req.getParameter("filename");

        //加载字节输入流加载文件
        //找到文件服务器路径
        String realPath = servletContext.getRealPath("/img/" + filename);
        //用字节流关联
        FileInputStream fis=new FileInputStream(realPath);

        //设置response的响应头
        //设置响应头类型
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        //中文文件问题
        //获取user-agent请求头
        String header = req.getHeader("user-agent");
        //使用工具类编码文件名
        filename= DownLoadUtils.getFileName(header,filename);
        //设置响应头的打开方式
        resp.setHeader("content-disposition","attachment;filename="+filename);

        //将输入流数据写出到输出流中
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while ((len=fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fis.close();
    }
}
