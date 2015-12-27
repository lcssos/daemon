package cn.martin.sitemesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 15/12/27.
 */
@Controller
@RequestMapping("/html")
public class HtmlController {

    @RequestMapping("/{h}.html")
    public String html(@PathVariable String h){
        return h;
    }
}
