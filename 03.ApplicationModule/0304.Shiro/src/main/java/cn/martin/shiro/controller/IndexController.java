package cn.martin.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 15/12/20.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return "index";
    }
}
