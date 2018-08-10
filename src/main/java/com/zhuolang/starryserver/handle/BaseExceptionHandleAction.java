package com.zhuolang.starryserver.handle;

import com.zhuolang.starryserver.dto.ResultDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义全局捕捉异常
 * Controller类继承这个类即可在产生异常时返回数据获取失败信息
 */
public class BaseExceptionHandleAction {


    /** 基于@ExceptionHandler异常处理 */
    /*@ExceptionHandler
    public ModelAndView  handleAndReturnPage(HttpServletRequest request, HttpServletResponse response, Exception ex) {

        ModelAndView  mv = new ModelAndView("Exception") ;
        mv.addObject("ex", ex);

        // 根据不同错误转向不同页面
        if (ex instanceof BusinessException) {
            return mv;
        } else {
            return mv; //返回Exception.jsp页面
        }
    }*/

    /** 基于@ExceptionHandler异常处理 */
    @ExceptionHandler
    @ResponseBody
    public ResultDto handleAndReturnData(Exception ex) {
        System.out.println("很好奇有没有执行到这里**handleAndReturnData************************************************************");
        return new ResultDto(500, "Error Exception===" + ex.getClass());
    }

}
