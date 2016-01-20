import cn.martin.es.entity.Doctor;
import cn.martin.es.service.JestClientService;
import com.alibaba.fastjson.JSON;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

/**
 * Created by lcssos on 16/1/8.
 */
@ContextConfiguration(locations = {
        "classpath:/applicationContext.xml"
})
public class JestClientServiceTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private JestClientService jestClientService;

    @Test
    public void test(){
       jestClientService.createDatebase("coupon2",5,1);
    }


    @Test
    public void test01(){
        jestClientService.createTable("npacs","doctor");
    }


    @Test
    public void test02(){
        Doctor doctor = new Doctor();
        doctor.setDoctorid("SDDFF");
        doctor.setName("张三");
        doctor.setHospital("北京中医院");
        doctor.setMessage("我是谁?");
        jestClientService.createDocument("npacs","doctor",doctor);
    }


    @Test
    public void test03(){
        SearchResult result = jestClientService.query("npacs","doctor","中院");
//        System.out.println(result.getJsonString());
        List<SearchResult.Hit<Doctor, Void>> doctorList = result.getHits(Doctor.class);
        for(SearchResult.Hit d : doctorList){
            System.out.println(JSON.toJSONString(d.source));
//            Doctor doctor = result.getSourceAsObject(Doctor.class);
//            Doctor doctor = (Doctor) d.source;
//            System.out.println(JSON.toJSONString(doctor));
        }

    }


    @Test
    public void test04(){
        Doctor doctor = jestClientService.get("npacs","doctor","AVIkeAUVoEuv9asohvP_",Doctor.class);
        System.out.println(JSON.toJSONString(doctor));
    }
}
