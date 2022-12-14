package Spring_MVC.com.Joker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Joker
 * @Date 2022/11/12 22:39
 * @Description get查询请求的映射-->@GETMapping
 * post新增请求的映射-->@POSTMapping
 * put修改请求的映射-->@PUTMapping
 * delete删除求情的映射-->@DELETEMapping
 *
 * @since version-1.0
 */
@Controller
// @RequestMapping("/hello")
public class RequestMappingController {

    // "/"-->/WEB-INF/templates/index.html
    // 在"/"里输入网址就会跳转到此路径，value可以省略
    // GETMapping也可作为RequestMethod.GET使用
    @RequestMapping(value = "/testRequestMapping",
            // RequestMethod可以支持GET和POST的传输工作
            method = {RequestMethod.GET, RequestMethod.POST})
    public String success(){
        return "success";
    }
    @RequestMapping(value = "/testParamsAndHeaders",
            // 传输参数
            params = {"username"},
            // 请求头,可以筛选括号中的参数
            headers = {"localhost:8080"}
            )
    public String testParamsAndHeaders(){
        return "success";
    }

    // ?：表示任意单个字符
    // *：代表任意的0个或多个字符
    // **：表示任意的一层或多层目录
    // 注意：在使用**时，只能使用/**/xxx的方式
    @RequestMapping("/a?a/testAnt")
    public String testAnt(){
        return "success";
    }

    // 占位符有两种：？id=xxx ， /{id}
    @RequestMapping("/testPath/{id}/{username}")

    // URL的参数可以通过@PathVariable注解的id传输到控制器进行修改等操作
    public String testpath(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }

}
