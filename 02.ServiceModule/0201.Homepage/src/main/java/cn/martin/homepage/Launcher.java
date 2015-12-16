package cn.martin.homepage;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
@Slf4j
public class Launcher implements Daemon{

    @Override
    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {

    }

    @Override
    public void start() throws Exception {
        startService();
        log.info("services started");
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void destroy() {

    }



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

    private static void startService() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        context.start();
        context.registerShutdownHook();
    }
}
