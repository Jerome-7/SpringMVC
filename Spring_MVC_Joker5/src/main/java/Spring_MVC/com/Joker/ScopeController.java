package Spring_MVC.com.Joker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Joker
 * @Date 2022/11/20 2:16
 * @Description 7种域对象的共享数据
 * @since version-1.0
 */
@Controller
public class ScopeController {

    // 使用ServletAPP向request域对象共享数据
    @RequestMapping("/testRequestByServletAPP")
    public String testRequestByServletAPP(HttpServletRequest request) {
        request.setAttribute("testRequsetScope", "hello,servletAPI");
        return "success";
    }

    // 使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        /**
         * ModelAndView有model和view的功能
         * model主要用于向请求域共享数据
         * view主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        // 处理模型数据，即向请求域request共享数据
        mav.addObject("testRequsetScope","hello,ModelAndView");
        // 设置视图名称，实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    // 使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequsetScope","hello,Model");
        return "success";
    }

    // 使用Map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequsetScope","hello,map");
        return "success";
    }

    // 使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequsetScope","hello,ModelMap");
        return "success";
    }

    // 使用ServletAPP向Session域对象共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hell,session");
        return "success";
    }

    // 使用ServletAPP向Application域对象共享数据
    @RequestMapping("/testApplication")
    public String testAPPlication(HttpSession session){
        ServletContext applicaton = session.getServletContext();
        applicaton.setAttribute("testApplicationScope","hello,applicaton");
        return "success";
    }

}
