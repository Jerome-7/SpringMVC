package com.Joker.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Joker
 * @Date 2022/12/12 0:34
 * @Description 注解异常处理
 * @since version-1.0
 */
// @ControllerAdvice也可以将类表示为组件的功能
@ControllerAdvice
public class ExceptionController {


    // @ExceptionHandler用于设置所标识方法处理的异常
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    // ex表示当前请求处理中出现的异常对象
    public String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
