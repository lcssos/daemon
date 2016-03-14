package cn.martin.upload.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2016/3/13.
 */
@RestController
@RequestMapping("/uploadify")
public class UploadifyController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam(value = "file_upload", required = false) MultipartFile filex) {
//        byte[] bytes = new byte[0];
//        try {
//            bytes = file.getBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(file.getOriginalFilename());
//        String uploadDir = request.getRealPath("/") + "upload";
//        File dirPath = new File(uploadDir);
//        if (!dirPath.exists()) {
//            dirPath.mkdirs();
//        }
//        String sep = System.getProperty("file.separator");
//        File uploadedFile = new File(uploadDir + sep  + file.getOriginalFilename());
//        try {
//            FileCopyUtils.copy(bytes, uploadedFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

        String responseStr="";
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //获取前台传值
        String[] userNames = multipartRequest.getParameterValues("userName");
        String[] contents = multipartRequest.getParameterValues("content");
        String userName="";
        String content="";
        if(userNames!=null){
            userName=userNames[0];
        }
        if(contents!=null){
            content=contents[0];
        }
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        //String ctxPath = request.getSession().getServletContext().getRealPath("/")+ "\\" + "images\\";
        String ctxPath=request.getSession().getServletContext().getRealPath("/");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String ymd = sdf.format(new Date());
        ctxPath += ymd + "/";

        System.out.println(ctxPath);

        //创建文件夹
        File file = new File(ctxPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = null;
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            // 上传文件名
            // System.out.println("key: " + entity.getKey());
            MultipartFile mf = entity.getValue();
            fileName = mf.getOriginalFilename();
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;

            System.out.println("newFileName:"+newFileName);
            File uploadFile = new File(ctxPath + newFileName);
            System.out.println(ctxPath + newFileName);
            try {
                FileCopyUtils.copy(mf.getBytes(), uploadFile);
                responseStr="上传成功";
            } catch (IOException e) {
                responseStr="上传失败";
                e.printStackTrace();
            }
        }
//        return null;


        return "true";
    }
}
