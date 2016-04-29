package cn.martin.log.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by lcssos on 16/4/25.
 */
@Service
@Slf4j
public class UserService {

    @PostConstruct
    public void init(){

        log.info("user service 启动了!");

    }

}
