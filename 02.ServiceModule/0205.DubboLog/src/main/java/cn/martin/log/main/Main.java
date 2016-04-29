package cn.martin.log.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lcssos on 16/4/25.
 */
public class Main {

    public static void main(String[] argus){

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        applicationContext.start();

        applicationContext.registerShutdownHook();

        synchronized (Main.class) {
            try {
                Main.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
