package com.zhuolang.starryserver.controller;

import com.zhuolang.starryserver.entity.User;
import com.zhuolang.starryserver.service.UserService;
import com.zhuolang.starryserver.dto.ResultDto;
import com.zhuolang.starryserver.utils.FileUploadUtil;
import com.zhuolang.starryserver.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
     *
     * @param request
     * @param response
     * @return
     * @throws IOException 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数，这里暂时用不到
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findUserByPhone")
    //@RequestMapping(value = "/findUserByPhone",method = RequestMethod.POST)//可以指定请求方式,如果不指定，默认post，get都可以
    public ResultDto findUserByPhone(HttpServletRequest request, HttpServletResponse response) {
        String phone = "";
        User user;
        try {
            //request.getParameter("phone")就是APP端传过来的请求参数
            phone = request.getParameter("phone");
            user = userService.findUserByPhone(phone);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDto(500, "Error Exception===" + e.getClass());
        }
        if (user == null) {
            //ResultDto返回数据的封装类，参数使用规则可自定义
            //例：
            // stauts:状态返回码，200：URL访问请求成功，并成功返回数据；500：URL访问请求成功但内部程序出错
            // msg：信息提示
            // data：需要的数据
            return new ResultDto(200, "nodata", null);
        } else {
            return new ResultDto(200, "success", user);
        }
    }

    /**
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findUserByPhone1")
    public User findUserByPhone1(HttpServletRequest request)
            throws IOException {

        //request.getParameter("phone")就是APP端传过来的请求参数
        String phone = request.getParameter("phone");

        User user = userService.findUserByPhone(phone);
        return user;
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws IOException 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数，这里暂时用不到
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findAllUser")
    public ResultDto findAllUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList;
        try {
            userList = userService.findAllUserDESC();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDto(500, "Error Exception===" + e.getClass());
        }
        if (userList != null && userList.size() > 0) {
            //ResultDto返回数据的封装类，参数使用规则可自定义
            //例：
            // stauts:状态返回码，200：URL访问请求成功，并成功返回数据；500：URL访问请求成功但内部程序出错
            // msg：信息提示
            // data：需要的数据
            return new ResultDto(200, "success", userList);
        } else {
            return new ResultDto(200, "nodata", null);
        }
    }

    /**
     * 数据更新例子
     *
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserByIdSelective")
    public ResultDto updateUserByIdSelective(HttpServletRequest request) {
        int result = 0;
        try {
            User user = new User();
            user.setPhone("18219111626");
            user.setPassword("123456");
            user.setName("福");
            user.setGender(1);
            user.setAge(23);
            user.setBirthday(TimeUtil.dateToStrNoTime(new Date()));//时间工具转换类
            user.setAddress("插入新地址");
//        int r = userService.updataUser(user);
//        int r = userService.updateUserByIdSelective(user);
            result = userService.insertUserSelective(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDto(500, "Error Exception===" + e.getClass());
        }
        if (result == 1) {
            return ResultDto.ok();
        } else {
            return ResultDto.failure();
        }

    }

    /**
     * 上传文件例子
     *
     * @param file
     * @param request
     */
    @ResponseBody
    @RequestMapping(value = "/uploadFile")
    public ResultDto uploadFile(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        //单个文件上传，返回文件上传后的名字
        String resultStr = FileUploadUtil.uploadFile(file,request);
        if (resultStr != null) {
            return new ResultDto(200, "success", resultStr);
        } else {
            return ResultDto.error();
        }
    }


    /**
     * 上传多个文件例子
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadFileList")
    public ResultDto uploadFileList(@RequestParam(value = "file") MultipartFile file[], HttpServletRequest request) {
        //多个文件上传，返回文件上传后的名字
        List<String> stringList = FileUploadUtil.uploadFileList(file, request);
        if (stringList != null) {
            return new ResultDto(200, "success", stringList);
        } else {
            return ResultDto.error();
        }
    }

}
