package cn.martin.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/3/13.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/uploadify")
    public String uploadify(){
        return "uploadify";
    }

    @RequestMapping(value = "/webuploader")
    public String webuploader(){
        return "webuploader";
    }
}
