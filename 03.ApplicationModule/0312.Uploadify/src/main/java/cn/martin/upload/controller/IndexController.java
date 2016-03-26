package cn.martin.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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
    public String webuploader(HttpServletRequest request){
        request.setAttribute("uuid", UUID.randomUUID().toString());
        return "webuploader";
    }


    @RequestMapping(value = "/webuploader2")
    public String webuploader2(HttpServletRequest request){
//        request.setAttribute("uuid", UUID.randomUUID().toString());
        return "webuploader2";
    }
}
