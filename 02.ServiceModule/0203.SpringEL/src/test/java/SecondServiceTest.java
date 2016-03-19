import cn.martin.spel.service.DictService;
import cn.martin.spel.service.SecondService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by lcssos on 16/1/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Profile("dev")
public class SecondServiceTest {

    @Resource
    private DictService dictService;
    @Resource
    private SecondService secondService;


    @Test
    public void test(){
        String ev = dictService.getEnvironment();
        System.out.println(ev);
    }

    @Test
    public void test02(){
//        String ev = dictService.getEnvironment();
//        System.out.println(ev);
        String s = secondService.getEnvironment();
        System.out.println(s);
    }

}
