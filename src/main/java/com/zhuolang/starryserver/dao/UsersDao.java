package com.zhuolang.starryserver.dao;

import com.zhuolang.starryserver.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 * 定义一些通过什么参数进行增删改查的方法，只需要定义，实现在对应的*Dao.xml里实现，这就是mybatis做的工作
 */
public interface UsersDao {//添加UserDao的test时，选中类名UserDao，右键go to->test-创建->选择Junit4,选择添加的测试方法，finish

    int deleteUsersById(int id);

    int deleteUsersByPhone(String phone);

    List<Users> findAllUsers();

    int updateUsersByIdSelective(@Param("user") Users user);

    int insertUsersSelective(@Param("user") Users user);

}
