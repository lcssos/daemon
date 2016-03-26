package cn.martin.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcssos on 16/3/19.
 */
@RestController
@RequestMapping("/webupload2")
@Slf4j
public class WebUploader2Controller {


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) Integer chunk,
                         @RequestParam(required = false) Integer chunks,
                         @RequestParam(required = false) String id,
                         @RequestParam(required = false) String guid) {



        return null;
    }


    /**
     * 上传文件前进行md5校验,判断文件是否已经上传
     * @return
     */
    @RequestMapping(value = "/md5Check",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> md5Check(String busiId,String md5){
        Map<String,Object> map = new HashMap<>();
        map.put("ifExist",false);
        map.put("path","");
        log.info("busiId:"+busiId);
        log.info("md5:"+md5);

        return map;
    }

    /**
     * 上传分片前进行校验,判断分片是否已经上传
     * @return
     */
    @RequestMapping(value = "/chunkCheck",method = RequestMethod.POST)
    public Map<String,Object> chunkCheck(String name,Integer chunkIndex,Long size){

        log.info("name:"+name);
        log.info("chunkIndex:"+chunkIndex);
        log.info("size:"+size);

        Map<String,Object> map = new HashMap<>();
        map.put("ifExist",false);

        return map;
    }

    @RequestMapping(value = "chunksMerge",method = RequestMethod.POST)
    public Map<String,Object> chunksMerge(String name,Integer chunks,String ext,String md5){
        Map<String,Object> map = new HashMap<>();

        return map;
    }
}
