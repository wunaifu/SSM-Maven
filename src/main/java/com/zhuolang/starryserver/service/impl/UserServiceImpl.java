package com.zhuolang.starryserver.service.impl;

import com.zhuolang.starryserver.dao.UserDao;
import com.zhuolang.starryserver.entity.User;
import com.zhuolang.starryserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 */
@Service
public class UserServiceImpl implements UserService{

    //注入Dao实现类依赖
    //    @Resource
    @Autowired
    private UserDao userDao;

    //也可以注入别的dao,例如对应post_tab表的PostDao，这样就可以根据需求整合多表的增删改查

//    @Resource
//    @Autowired
//    private UserDao userDao;

    /**注册会用到
     * 通过 phone和password 来添加 User
     * @param phone
     * @param password
     * @return 插入的行数
     */
    public int addUserByPhonePsw(String phone, String password) {
        return userDao.addUserByPhonePsw(phone,password);
    }

    /**
     * 通过phone删除User
     * @param phone
     * @return 删除成功返回1，失败返回0
     */
    public int deleteUserByPhone(String phone) {
        return userDao.deleteUserByPhone(phone);
    }

    /**
     * 通过phone和password更新User密码，新密码不能和旧密码一样
     * @param phone
     * @param password
     * @return 更新成功返回1，失败返回0
     */
    public int updatePswByPhonePsw(String phone, String password) {
        return userDao.updatePswByPhonePsw(phone,password);
    }

    /**
     * 通过phone检验旧密码是否正确
     * @param phone
     * @param oldPassword
     * @return 正确返回1，错误返回0
     */
    public int checkPassword(String phone, String oldPassword) {
        User user = userDao.checkPassword(phone,oldPassword);
        if (user == null) {
            System.out.println("密码错误==="+user);
            return 0;
        }else {
            System.out.println("密码正确==="+user);
            return 1;
        }
    }


    /**
     * 通过phone查询User信息
     * @param phone
     * @return 查找成功返回User，没有则null
     */
    public User findUserByPhone(String phone) {
        return userDao.findUserByPhone(phone);
    }

    /**
     * 查找所有User，并按年龄降序排序好
     * @return
     */
    public List<User> findAllUserDESC() {
        return userDao.findAllUserDESC();
    }

    /**
     * 通过id完善用户表
     */
    public int updataUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int updateUserByIdSelective(User user) {
        return userDao.updateUserByIdSelective(user);
    }

    @Override
    public int insertUserSelective(User user) {
        return userDao.insertUserSelective(user);
    }
}
