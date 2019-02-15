package top.dearan.dissertation.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : dingshuangen
 * @Date : 2019/1/13 0013
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("../static/index.html");
        return modelAndView;
    }
}
