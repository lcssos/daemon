package cn.martin.log4j.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 15/12/27.
 */
@Controller
public class Log4jController {
//    Logger logger = LoggerFactory.getLogger(Log4jController.class);
    Logger logger = Logger.getLogger(Log4jController.class);

    @RequestMapping("/log4j")
    public String log(){

        logger.info("打印Log4j日志");

        return "index";
    }


}
