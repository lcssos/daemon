package cn.martin.mongodb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 16/3/30.
 */
@Controller
@Slf4j
public class IndexController {



    @RequestMapping({"","/"})
    public String index(){

        log.info("index首页!");

        return "index";
    }
}
