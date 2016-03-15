package cn.martin.upload.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(WebUploaderController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String upload(MultipartFile file,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) Integer chunk,
                         @RequestParam(required = false) Integer chunks,
                         @RequestParam(required = false) String formData) {

        logger.info("name:"+name);

//        String fileName = file.getOriginalFilename();
//        logger.info("fileName:"+fileName);

        logger.info("chunck:"+chunk);
        logger.info("chuncks:"+chunks);
//        file.getInputStream();

        File uploadFile = new File(name);
        try {
            OutputStream os = new FileOutputStream(uploadFile);
            IOUtils.copy(file.getInputStream(),os);
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
