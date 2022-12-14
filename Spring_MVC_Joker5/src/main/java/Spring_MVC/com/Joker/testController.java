package Spring_MVC.com.Joker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker
 * @Date 2022/11/20 1:35
 * @Description 页面跳转类
 * @since version-1.0
 */
@Controller
public class testController {

    // 视图控制器
    // 如果视图中无前缀可以在resources中的SpringMVC.xml中编写
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }
}
