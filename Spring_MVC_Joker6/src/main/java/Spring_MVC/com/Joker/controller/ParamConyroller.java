package Spring_MVC.com.Joker.controller;

import Spring_MVC.com.Joker.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author Joker
 * @Date 2022/11/13 22:08
 * @Description 将用户信息打印在控制器
 * @since version-1.0
 */
@Controller
public class ParamConyroller {

    @RequestMapping("/testServletAPI")
    // 形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        System.out.println("username:"+username+",password:"+ password);
        return "success";
    }
    // 形参可以使用控制器表示当前请求
    // 控制器显示形参必须要与请求参数名字一致，才可以打印出来
    @RequestMapping("testParam")
    // 控制器显示形参必须要与请求参数名字一致，才可以打印出来
    public String testParam(
            // @RequestParam注解是对请求参数和形参创建一个映射关系
            // value表示必须与参数进行映射，required表示是否与参数进行映射,treu表示必须传输参数，false表示有参数则传输参数，没有则不传输（null）
            // defaultValue代表默认值，不传输请求参数则传输默认值，URL里传输值为空时同样传输默认值
            @RequestParam(value = "user_name",required = false,defaultValue = "hh") String username,
            String password,
            String[] hobby,
            // @RequestHeader注解是将请求头信息和控制器方法的形参创建映射关系
            @RequestHeader(value = "sayhh",required = true,defaultValue = "hh")String host,
            // @CookieValue注解是将coolie数据和控制器方法的形参创建映射关系
            @CookieValue(value = "JSESSIONID",required = false,defaultValue = "77")String JSESSIONID){
        // 若请求参数中出现多个同名请求参数时，可以在控制器方法的形参位置设置字符串类型或数组接受此请求参数
        // 若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:"+username+",passwaord:"+password+",hobby:"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testPOJO")
    public String testPOJO(User user){
        System.out.println(user);
        return "success";
    }
}
