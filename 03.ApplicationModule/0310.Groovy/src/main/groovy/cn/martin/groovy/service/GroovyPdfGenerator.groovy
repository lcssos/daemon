package cn.martin.groovy.service

import org.springframework.stereotype.Service

/**
 * Created by lcssos on 16/1/5.
 */

@Service
class GroovyPdfGenerator {



    public String print(String word){
        println(word);
        return "xxx" + word;
    }
}
