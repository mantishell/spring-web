package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    public SpitterController(){

    }

    public SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(ModelMap mmap){
        mmap.put("spitter", new Spitter());
        return "registerForm";
    }

    /**
     * 当 InternalResourceViewResolver 看到视图格式中的 redirect: 前缀时，它就知道要将其解析为重定向的规则，
     * 而不是视图的名称。在本例中，它将会重定向到用户基本信息的页面。例如，如果 Spitter.username 属性的值为jbauer，
     * 那么视图将会重定向到 /spitter/jbauer。
     *
     * 需要注意的是，除 了 redirect:，InternalResourceViewResolver 还能识别forward: 前缀。当它发现视图格式中以 forward: 作
     * 为前缀时，请求将会前往（forward）指定的 URL 路径，而不再是重定向。
     *
     * @param spitter
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String proecssRegistration(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
