package spittr.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/")//将路径映射到类上
@RequestMapping({"/", "/homepage"})//这样的话，HomeController 的 home() 方法能够映射到对 / 和 /homepage 的 GET 请求。
public class HomeController {

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)//HTTP方法映射到方法上
    public String home(Model model){
        return "home";
    }
}
