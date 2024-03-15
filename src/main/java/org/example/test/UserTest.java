package org.example.test;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.junit.Test;

public class UserTest {


    @Test
    public void test(){
        User user=new User();
        user.setUsername("Tom");
        user.setPassword("123");
        UserDao dao=new UserDao();
        User login = dao.login(user);
        System.out.println(login);
    }
}
