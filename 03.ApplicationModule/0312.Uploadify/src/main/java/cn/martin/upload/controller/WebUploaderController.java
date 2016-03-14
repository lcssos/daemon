package cn.martin.upload.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2016/3/13.
 */
@RestController
@RequestMapping("/webupload")
public class WebUploaderController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String upload(MultipartFile file) {

//        file.getInputStream();

        File uploadFile = new File("aaa.xtf");
        try {
            OutputStream os = new FileOutputStream(uploadFile);
            IOUtils.copy(file.getInputStream(),os);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
