package Spring_MVC.com.Joker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker
 * @Date 2022/11/25 17:56
 * @Description SpringMVC的视图
 * @since version-1.0
 */
@Controller
public class ViewController {

    // ThymeleafView：当控制器方法中所设置的视图名称没有任何前缀时
    // 此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析
    // 视图名称拼接视图前缀和视图后缀所得的最终路径，会通过转发的方式实现跳转
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    // 转发视图
    // 使用forward:/URL时，URL显示为/testForward
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    // 重定向视图
    // 使用redirect:/URL时，URL显示为/testThymeleafView
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }

    // 视图控制器view-controller
    //@RequestMapping("")

}
