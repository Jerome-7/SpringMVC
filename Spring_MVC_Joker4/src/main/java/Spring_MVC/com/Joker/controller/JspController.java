package Spring_MVC.com.Joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Joker
 * @Date 2022/11/26 1:48
 * @Description This is description of class
 * @since version-1.0
 */
@Controller
public class JspController {

    @RequestMapping("/success")
    private String success(){
        return "success";
    }
}
