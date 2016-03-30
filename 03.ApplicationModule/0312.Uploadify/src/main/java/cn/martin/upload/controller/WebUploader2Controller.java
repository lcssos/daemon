package cn.martin.upload.controller;

import cn.martin.upload.entity.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcssos on 16/3/19.
 */
@RestController
@RequestMapping("/webupload2")
@Slf4j
public class WebUploader2Controller {

    private String uploadFolder = "/Users/lcssos/wks/tmp";


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file,
                         Param param) {

        log.info("-------upload-----------");
        log.info("name:"+param.getName());
        log.info("type:"+param.getType());
        log.info("lastModifiedDate:"+param.getLastModifiedDate());
        log.info("md5:"+param.getMd5());
        log.info("ext:"+param.getExt());

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

        log.info("-------------md5Check------------");
        log.info("busiId:"+busiId);
        log.info("md5:"+md5);

        return map;
    }

    /**
     * 上传分片前进行校验,判断分片是否已经上传
     * @return
     */
    @RequestMapping(value = "/chunkCheck",method = RequestMethod.POST)
    public Map<String,Object> chunkCheck(String uniqueName,Integer chunkIndex,Long size){

        log.info("-------------chunkCheck----------");
        log.info("uniqueName:"+uniqueName);
        log.info("chunkIndex:"+chunkIndex);
        log.info("size:"+size);

        Map<String,Object> map = new HashMap<>();
        map.put("ifExist",false);

        return map;
    }

    @RequestMapping(value = "chunksMerge",method = RequestMethod.POST)
    public Map<String,Object> chunksMerge(String uniqueName,Integer chunks,String ext,String md5){
        Map<String,Object> map = new HashMap<>();


        log.info("---------chunksMerge--------------");
        log.info("uniqueName:"+uniqueName);
        log.info("chunks:"+chunks);
        log.info("ext:"+ext);
        log.info("md5:"+md5);

        return map;
    }






    /**
     * MD5签名
     * @param content   要签名的内容
     * @return
     */
    private String md5(String content){
        StringBuffer sb = new StringBuffer();
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(content.getBytes("UTF-8"));
            byte[] tmpFolder = md5.digest();

            for(int i = 0; i < tmpFolder.length; i++){
                sb.append(Integer.toString((tmpFolder[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        }catch(NoSuchAlgorithmException ex){
            log.error("无法生成文件的MD5签名", ex);
            return null;
        }catch(UnsupportedEncodingException ex){
            log.error("无法生成文件的MD5签名", ex);
            return null;
        }
    }
}
