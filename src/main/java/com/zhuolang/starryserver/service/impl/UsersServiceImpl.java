package com.zhuolang.starryserver.service.impl;

import com.zhuolang.starryserver.dao.UsersDao;
import com.zhuolang.starryserver.entity.User;
import com.zhuolang.starryserver.entity.Users;
import com.zhuolang.starryserver.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 */
@Service
public class UsersServiceImpl implements UsersService {

    //注入Dao实现类依赖
    //    @Resource
    @Autowired
    private UsersDao usersDao;

    @Override
    public int deleteUsersById(int id) {
        return usersDao.deleteUsersById(id);
    }

    @Override
    public int deleteUsersByPhone(String phone) {
        return usersDao.deleteUsersByPhone(phone);
    }

    @Override
    public List<Users> findAllUsers() {
        return usersDao.findAllUsers();
    }

    @Override
    public int updateUsersByIdSelective(Users user) {
        return usersDao.updateUsersByIdSelective(user);
    }

    @Override
    public int insertUsersSelective(Users user) {
        return usersDao.insertUsersSelective(user);
    }
}
