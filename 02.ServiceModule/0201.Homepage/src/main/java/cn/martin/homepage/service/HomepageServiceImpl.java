package cn.martin.homepage.service;

import cn.martin.dubbo.homepage.HomepageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lcssos on 15/12/15.
 */

@Service
//@Transactional
@Slf4j
public class HomepageServiceImpl implements HomepageService {
    @Override
    public int getHomepageCount() {
        log.info("get homepage count");
        return 100;
    }
}
