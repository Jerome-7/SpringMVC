package Spring_MVC.com.Joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker
 * @Date 2022/11/12 17:56
 * @Description This is description of class
 * @since version-1.0
 */
// 将HelloController设置为控制层
@Controller
public class Testcontroller {

    // "/"-->/WEB-INF/templates/index.html
    // 在"/"里输入网址就会跳转到此路径，value可以省略
    // GETMapping也可作为RequestMapping使用
    @RequestMapping("/")
    public String index(){
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }

}
