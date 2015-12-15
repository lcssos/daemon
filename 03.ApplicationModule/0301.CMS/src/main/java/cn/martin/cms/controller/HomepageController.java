package cn.martin.cms.controller;

import cn.martin.dubbo.homepage.HomepageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lcssos on 15/12/15.
 */
@Controller
@RequestMapping("/homepage")
public class HomepageController {

    @Resource
    private HomepageService homepageService;

    @RequestMapping("/count")
    public @ResponseBody int count(){
        return homepageService.getHomepageCount();
    }


}
