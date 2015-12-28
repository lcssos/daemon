package cn.martin.tf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/12/28.
 */
@Controller
@RequestMapping("/Content")
public class ContentController {

    @RequestMapping("/1.html")
    public String content1(){
        return "Content1";
    }

    @RequestMapping("/2.html")
    public String content2(){
        return "Content2";
    }
}
