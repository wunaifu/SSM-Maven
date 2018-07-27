package com.zhuolang.starryserver.dao;

import com.zhuolang.starryserver.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void addUserByPhonePsw() {

    }

    @Test
    public void addUserByPhonePsw1() {
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
    public void updateUser() {
    }

    @Test
    public void updateUserByIdSelective() {
        User user = new User();
        user.setId(1);
        user.setAddress("更新地址啦");
        user.setAge(23);
        user.setHeight("sdfdfsa");
        System.out.println(userDao.findUserByPhone("1"));
        //System.out.println(userDao.updateUserByIdSelective(user));
    }
}