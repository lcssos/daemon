package cn.martin.homepage;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lcssos on 15/12/16.
 */
public class WrapperLauncher implements WrapperListener {

    @Override
    public Integer start(String[] strings) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();
//        context.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            String input = "";
            try {
                if (br.ready()) {
                    input = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (input.equals("stop")) {
                break;
            }
        } while (br != null);
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int stop(int i) {
        return 0;
    }

    @Override
    public void controlEvent(int i) {

    }

//    public static void main(String[] args) {
//        WrapperManager.start(new WrapperLauncher(), args);
//    }
}
