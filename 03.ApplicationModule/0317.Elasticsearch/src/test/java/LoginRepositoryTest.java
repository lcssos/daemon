import cn.martin.es.entity.Login;
import cn.martin.es.repository.LoginRepository;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by lcssos on 16/4/23.
 */
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:applicationContext-elasticsearch.xml"
})
public class LoginRepositoryTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private LoginRepository loginRepository;


    @Test
    public void test(){
        Login login1 = new Login();
        login1.setUuid(1L);
        login1.setName("张三");
        login1.setLoginname("zhangsan");
        login1.setEmail("zhangsan@163.com");
        login1.setPassword("zpwd");
        login1.setComments("我是张三,我来自北京市");
        loginRepository.save(login1);

        Login login2 = new Login();
        login2.setUuid(2L);
        login2.setName("李四");
        login2.setLoginname("lisi");
        login2.setEmail("lisi@126.com");
        login2.setPassword("lpwd");
        login2.setComments("我是李四,我来自山东省");
        loginRepository.save(login2);


        Login login3 = new Login();
        login3.setUuid(3L);
        login3.setName("王五");
        login3.setLoginname("wangwu");
        login3.setEmail("wangwu@126.com");
        login3.setPassword("wpwd");
        login3.setComments("我是王五,我来自山东省");
        loginRepository.save(login3);

    }


    @Test
    public void test01(){
        Login login = loginRepository.findByUuid(1L);
        System.out.println(JSON.toJSONString(login));
    }

    @Test
    public void test02(){
        List<Login> logins = loginRepository.findByCommentsLike("山东");
        System.out.println(JSON.toJSONString(logins));
    }


    @Test
    public void test03() throws Exception {
        Login login4 = new Login();
        login4.setUuid(4L);
        login4.setName("李六");
        login4.setLoginname("liliu");
        login4.setEmail("liliu@126.com");
        login4.setPassword("lpwd");
        login4.setComments("我是李六,我来自山东省");

//        File file = new File("/Users/lcssos/Documents/刘昌胜个人简历2016.docx");
//        login4.setIntroduction(encodeBase64File("/Users/lcssos/Documents/刘昌胜个人简历2016.docx"));

        loginRepository.save(login4);
    }


    @Test
    public void test04(){
        List<Login> logins = loginRepository.findByCommentsLike("李六");
        System.out.println(JSON.toJSONString(logins));
    }


    @Test
    public void testDecode(){
        try {
            String s = decodeBase64("e1xydGYxXGFuc2kNCkxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0DQpccGFyIH0=");
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);;
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();

//        new BASE64Decoder().decode

        return new BASE64Encoder().encode(buffer);
    }



    public static String decodeBase64(String str) throws IOException {
        return new String(new BASE64Decoder().decodeBuffer(str));
    }

}
