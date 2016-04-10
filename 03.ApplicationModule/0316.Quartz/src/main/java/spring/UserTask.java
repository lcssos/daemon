package spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/4/11.
 */

public class UserTask {

    Logger logger = LoggerFactory.getLogger(UserTask.class);
    public void execute(){
        logger.info("UserTask 正在运行");
    }
}
