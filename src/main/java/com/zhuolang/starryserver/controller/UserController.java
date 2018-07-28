package com.zhuolang.starryserver.controller;

import com.zhuolang.starryserver.entity.User;
import com.zhuolang.starryserver.service.UserService;
import com.zhuolang.starryserver.utils.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wunaifu on 2018/7/28.
 */
//tomcat配置好的项目地址是 + controller配好的RequestMapping + controller里面的接口方法配置好的RequestMapping
//    就是网络请求时的地址，即访问controller中某方法的网络地址URL
//    例如：http://localhost:8080/user/allUser --》就访问了findAllUserDESC（）方法
@Controller
@RequestMapping("/user")
public class UserController {

    //这里写的每个方法都要注释好是干什么的，有复杂的逻辑处理关系的也要注释好，便于别人读懂你的代码
    //PS:controller一般只处理获取数据，将数据传到service业务层，不做复杂的数据处理，复杂的数据处理交给service业务层

    //注入Service实现类依赖，可注入多个Service依赖
    @Autowired
    private UserService userService;

    /**
     * 通过phone查找用户的信息（可用于查看用户信息功能的请求接口）
     * @param request
     * @param response
     * @return
     * @throws IOException
     * 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数，这里暂时用不到
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findUserByPhone")
    public ResultDto findUserByPhone(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        //request.getParameter("phone")就是APP端传过来的请求参数
        String phone = request.getParameter("phone");

        User user = userService.findUserByPhone(phone);
        if (user == null) {
            //ResultDto返回数据的封装类
            return new ResultDto(200,"没有找到数据",null);
        } else {
            return new ResultDto(200,"找到数据了",user);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateUserByIdSelective")
    public ResultDto updateUserByIdSelective(HttpServletRequest request)
            throws IOException{

        User user = new User();
        user.setPhone("123");
        user.setPassword("123456");
        user.setName("福");
        user.setGender(1);
        user.setAge(23);
        user.setBirthday("2018-01-29");
        user.setAddress("插入新地址");

//        int r = userService.updataUser(user);
//        int r = userService.updateUserByIdSelective(user);
        int r = userService.insertUserSelective(user);
        if (r == 1) {
            return new ResultDto(200,"更新成功");
        } else {
            return new ResultDto(200,"更新失败");
        }

    }
}
