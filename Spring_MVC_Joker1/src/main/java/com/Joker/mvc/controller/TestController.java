package com.Joker.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joker
 * @Date 2022/12/9 21:32
 * @Description 控制层
 * @since version-1.0
 */
@RestController
public class TestController {

    // 拦截器
    @RequestMapping("/**/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

    @RequestMapping("/testExceptionHandler")
    public String ExceptionHandler(){
        System.out.println(1/0);
        return "error";
    }

}
