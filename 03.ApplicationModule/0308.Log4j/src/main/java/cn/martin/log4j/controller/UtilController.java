package cn.martin.log4j.controller;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by lcssos on 15/12/27.
 */
@Controller
public class UtilController {

    Logger logger = Logger.getLogger("cn.martin.log4j.controller.UtilController");

    @RequestMapping("/util")
    public String util(){
        logger.info("打印java util日志");
        return "index";
    }


    @PostConstruct
    public void init(){
        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        Logger.getLogger("global").setLevel(Level.FINEST);
    }
}
