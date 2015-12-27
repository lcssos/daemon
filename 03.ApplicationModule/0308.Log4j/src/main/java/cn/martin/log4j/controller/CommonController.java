package cn.martin.log4j.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 15/12/27.
 */
@Controller
public class CommonController {

    Log logger = LogFactory.getLog(CommonController.class);

    @RequestMapping("/common")
    public String common(){
        logger.debug("打印Common Log日志");
        return "index";
    }
}
