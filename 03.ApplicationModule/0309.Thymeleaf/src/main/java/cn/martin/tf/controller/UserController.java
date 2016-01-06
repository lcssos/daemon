package cn.martin.tf.controller;

import cn.martin.tf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lcssos on 16/1/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/create.html",method = RequestMethod.GET)
    public String create(Model model){

        User user = new User();
        user.setName("张三");

        user.setLastName("三");

        model.addAttribute("user",user);

        return "user/form";
    }
}
