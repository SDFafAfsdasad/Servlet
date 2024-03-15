package org.example.dao;

import org.example.domain.User;
import org.example.utils.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操纵数据库中user表的类
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtil.getDataSource());

    public User login(User user){
        try {
            //编写sql
            String sql="select * from user where username= ? and password= ?";
            //调用query方法
            User res=template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    user.getUsername(),
                    user.getPassword());
            return res;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

}
