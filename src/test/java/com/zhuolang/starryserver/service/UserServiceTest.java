package com.zhuolang.starryserver.service;

import com.zhuolang.starryserver.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void addUserByPhonePsw() {
        System.out.println(userService.addUserByPhonePsw("18219111627","123456"));
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setPhone("18219111619");
        user.setPassword("123456");
        System.out.println(userService.addUser(user));
//        user.getId();
        System.out.println(user);
    }

    @Test
    public void deleteUserByPhone() {
    }

    @Test
    public void updatePswByPhonePsw() {
    }

    @Test
    public void checkPassword() {
    }

    @Test
    public void findUserByPhone() {
    }

    @Test
    public void findAllUserDESC() {
    }

    @Test
    public void updataUser() {
    }

    @Test
    public void updateUserByIdSelective() {
    }

    @Test
    public void insertUserSelective() {
    }
}