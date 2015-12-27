package cn.martin.sitemesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcssos on 15/12/27.
 */
@Controller
@RequestMapping("/ajax")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> hello(){
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        map.put("message","0k");

        return map;
    }
}
