package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/4/11.
 */
public class Launcher {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();

        synchronized(Launcher.class){

            try {
                Launcher.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
