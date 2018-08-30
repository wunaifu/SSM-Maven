package com.zhuolang.starryserver.controller;

import com.zhuolang.starryserver.dto.ResultDto;
import com.zhuolang.starryserver.entity.User;
import com.zhuolang.starryserver.entity.Users;
import com.zhuolang.starryserver.handle.BaseExceptionHandleAction;
import com.zhuolang.starryserver.service.UserService;
import com.zhuolang.starryserver.service.UsersService;
import com.zhuolang.starryserver.utils.FileUploadUtil;
import com.zhuolang.starryserver.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by wunaifu on 2018/7/28.
 */
//tomcat配置好的项目地址是 + controller配好的RequestMapping + controller里面的接口方法配置好的RequestMapping
//    就是网络请求时的地址，即访问controller中某方法的网络地址URL
//    例如：http://localhost:8080/user/allUser --》就访问了findAllUserDESC（）方法
@Controller
@RequestMapping("/users")//Controller类继承BaseExceptionHandleAction这个类即可在产生异常时返回数据获取失败的异常类信息
public class UsersController extends BaseExceptionHandleAction {

    //这里写的每个方法都要注释好是干什么的，有复杂的逻辑处理关系的也要注释好，便于别人读懂你的代码
    //PS:controller一般只处理获取数据，将数据传到service业务层，不做复杂的数据处理，复杂的数据处理交给service业务层

    //注入Service实现类依赖，可注入多个Service依赖
    @Autowired
    private UsersService usersService;


    /**
     * @param request
     * @param response
     * @return
     * @throws IOException 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数，这里暂时用不到
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findAllUser")
    public ResultDto findAllUser(HttpServletRequest request, HttpServletResponse response) {

        List<Users> userList = usersService.findAllUsers();

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
     * 用户列表
     * @param request
     * @param response
     * @return
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/list")
    public List<Users> userList(HttpServletRequest request, HttpServletResponse response) {
        List<Users> userList = usersService.findAllUsers();
        return userList;
    }

    /**
     * 添加用户
     * @param request
     * @param response
     * @return
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/save")
    public String userSave(HttpServletRequest request, HttpServletResponse response) {

        Users user = new Users();
        user.setPhone(request.getParameter("phone"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        int result = usersService.insertUsersSelective(user);
        if (result == 1) {
            return "success";
        }
        return "error";
    }

    /**
     * 更新用户
     * @param request
     * @param response
     * @return
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/update")
    public String userUpdate(int id, HttpServletRequest request, HttpServletResponse response) {

        Users user = new Users();
        user.setId(id);
        user.setPhone(request.getParameter("phone"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        int result = usersService.updateUsersByIdSelective(user);
        if (result == 1) {
            return "success";
        }
        return "error";
    }

    /**
     * 删除用户
     * @param request
     * @param response
     * @return
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/del")
    public ResultDto userDel(int id,HttpServletRequest request, HttpServletResponse response) {
        //String phone = request.getParameter("phone");
        int result = usersService.deleteUsersById(id);
        if (result == 1) {
            return ResultDto.ok();
        }
        return ResultDto.error();
    }
}
