package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.data.SpittleRepository;

import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        /**
         * 1、当调用 addAttribute() 方法并且不指定 key 的时候，那么 key 会根据值的对象类型推断确定。在本例中，因为它是一个 List<Spittle>，因此，键将会推断为 spittleList。
         */
        //model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        /**
         * 2、显式声明模型的 key
         */
        model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    /**
     * 3、如果你希望使用非 Spring 类型的话，那么可以用 java.util.Map 来代替 Model
     */
    /*@RequestMapping(method = RequestMethod.GET)
    public String spittles(Map model){
        model.put("splittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }*/
}
