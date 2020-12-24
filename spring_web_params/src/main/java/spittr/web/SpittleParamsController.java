package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.List;

/**
 * 处理查询参数 params
 */
@Controller
@RequestMapping("/spittles")
public class SpittleParamsController {

    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

    @Autowired
    public SpittleParamsController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam("max") long max, @RequestParam("count") int count){
        return spittleRepository.findSpittles(max, count);
    }

    /**
     * 处理有参和无参
     */
    @RequestMapping(value = "/default",method = RequestMethod.GET)
    public List<Spittle> spittles2(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count){
        return spittleRepository.findSpittles(max, count);
    }
}
