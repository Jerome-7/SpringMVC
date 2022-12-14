package Spring_MVC.com.Joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker
 * @Date 2022/11/6 18:27
 * @Description @RequestMapping注解的使用方法
 * @since version-1.0
 */
// 将HelloController设置为控制层
@Controller
public class HelloController {

    // "/"-->/WEB-INF/templates/index.html
    // 在"/"里输入网址就会跳转到此路径，value可以省略
    @RequestMapping(value = "/")
    public String index(){
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}
