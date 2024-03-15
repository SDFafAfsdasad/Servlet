package org.example.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
* JDBC工具类，使用Druid连接池
* */
public class JDBCUtil {

    private static DataSource ds;

    static {
        try {
        //静态代码块，加载配置文件
        Properties pro=new Properties();
        //使用ClassLoader加载配置文件，获取字节输入流
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(resourceAsStream);

        //初始化连接池对象
            ds=DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

    //获取连接Connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
