package cn.martin.homepage;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        Provider.startService();
        log.info("services started");
    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void destroy() {

    }
}
