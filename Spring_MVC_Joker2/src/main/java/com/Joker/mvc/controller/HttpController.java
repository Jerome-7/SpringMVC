package com.Joker.mvc.controller;

import com.Joker.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Joker
 * @Date 2022/12/3 22:21
 * @Description @ResponseBody注解
 * @since version-1.0
 */
// @RestController注解可以将当前类增加@Controller及方法里都增加了@ResponseBody
@RestController
public class HttpController {

    @RequestMapping("/testRequestBody")
    // @RequestBody注解可以获取前端输出的值并保存
    public String testRequestBody(@RequestBody String requestBoby){
        System.out.println("RequestBody:"+requestBoby);
        return "success";
    }

    @RequestMapping("/testResponse")
    // @Response注解的第一种写法
    public void testResponse(HttpServletResponse response) throws IOException {
        // 输出并打印
        response.getWriter().print("hello,response");
    }

    @RequestMapping("/testResponseBody")
    // @ResponseBody注解可以忽视.html文件并输出值
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"Joker","789",20,"女");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }
}
