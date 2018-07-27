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
 * Created by wunaifu on 2017/8/8.
 */
//@Component
    @Controller
@RequestMapping("/user")
//tomcat配置好的项目地址是 + controller配好的RequestMapping + controller里面的接口方法配置好的RequestMapping
//    就是网络请求时的地址，即访问controller中某方法的网络地址URL
//    例如：http://localhost:8080/userController/allUser --》就访问了findAllUserDESC（）方法
public class UserController {

    //这里写的每个方法都要注释好是干什么的，有复杂的逻辑处理关系的也要注释好，便于别人读懂你的代码

    //注入Service实现类依赖，可注入多个Service依赖
    @Autowired
    private UserService userService;

    /**
     * 通过phone查找用户的信息（可用于查看用户信息功能的请求接口）
     * @param request
     * @param response
     * @return
     * @throws IOException
     * 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数
     */
    @ResponseBody
    @RequestMapping(value = "/findUserByPhone")
    public ResultDto findUserByPhone(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("UTF-8");

        //request.getParameter("phone")就是APP端传过来的请求参数
        String phone = request.getParameter("phone");

        User user = userService.findUserByPhone(phone);
        if (user == null) {
            return new ResultDto(200,"没有找到数据",null);
        } else {
            return new ResultDto(200,"找到数据了",user);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/updateUserByIdSelective")
    public ResultDto updateUserByIdSelective(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        User user = new User();
        user.setId(1);
        user.setAddress("更新地址啦");
        user.setAge(23);
        user.setHeight("sdfdfsa");

        int r = userService.updateUserByIdSelective(user);
        if (r == 1) {
            return new ResultDto(200,"更新成功",user);
        } else {
            return new ResultDto(200,"更新失败",null);
        }

    }
}
