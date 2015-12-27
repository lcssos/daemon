package cn.martin.log4j.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 15/12/27.
 */
@Controller
public class Slf4jController {

    Logger logger = LoggerFactory.getLogger(Slf4jController.class);

    @RequestMapping("/slf4j")
    public String slf4j(){

        logger.debug("打印Slf4j日志");

        return "index";
    }
}
