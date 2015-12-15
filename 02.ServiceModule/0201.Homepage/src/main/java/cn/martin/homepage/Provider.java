package cn.martin.homepage;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by huangxiang on 15-12-8.
 */
@Slf4j
public class Provider {

    public static void main(String[] args) throws Exception {
        startService();
        log.debug("服务已启动，输入stop结束");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            String input = "";
            if (br.ready()) {
                input = br.readLine();
            }
            if (input.equals("stop")) {
                break;
            }
        } while (br != null);
        br.close();
    }

    static void startService() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        context.start();
        context.registerShutdownHook();
    }
}
