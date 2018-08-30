package com.zhuolang.starryserver.service;

import com.zhuolang.starryserver.entity.User;
import com.zhuolang.starryserver.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 * 定义方法，只需要定义，实现在对应的*ServiceImpl.java里实现，这就是spring做的工作
 */
public interface UsersService {
    int deleteUsersById(int id);

    int deleteUsersByPhone(String phone);

    List<Users> findAllUsers();

    int updateUsersByIdSelective(@Param("user") Users user);

    int insertUsersSelective(@Param("user") Users user);
}