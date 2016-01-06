package cn.martin.groovy.controller;

import cn.martin.groovy.service.GroovyPdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lcssos on 16/1/5.
 */
@Controller
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private GroovyPdfGenerator groovyPdfGenerator;

    @RequestMapping("/print")
    public String print(){

        groovyPdfGenerator.print("123");

        return "pdf";
    }
}
