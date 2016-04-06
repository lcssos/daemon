package cn.martin.druid.controller;

import cn.martin.druid.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/3/13.
 */
@RestController
@RequestMapping("/file")
public class FileController {



    @Resource
    private FileService fileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String upload() {

        fileService.findOne(0L);
        return "file";
    }
}
