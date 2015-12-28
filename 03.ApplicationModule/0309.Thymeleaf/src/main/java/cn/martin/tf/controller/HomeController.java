package cn.martin.tf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 15/12/27.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name","刘昌胜");
        return "home";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
