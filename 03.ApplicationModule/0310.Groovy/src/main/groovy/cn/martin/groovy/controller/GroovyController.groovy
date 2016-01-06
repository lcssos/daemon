package cn.martin.groovy.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import javax.annotation.Resource

/**
 * Created by lcssos on 16/1/6.
 */
@Controller
@RequestMapping("/groovy")
class GroovyController {

    @Resource
    def groovyPdfGenerator;

    @RequestMapping("/print")
    def print(){
        groovyPdfGenerator.print("xxff")
        print("456")
        return "pdf"
    }
}
