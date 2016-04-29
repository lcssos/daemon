package cn.martin.es.entity;

import cn.martin.es.repository.BookRepository;
import cn.martin.es.repository.PersonRepository;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by lcssos on 16/4/23.
 */
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:applicationContext-elasticsearch.xml"
})
public class PersonRepositoryTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private PersonRepository personRepository;

    @Test
    public void test01(){
        Person person = new Person();
        person.setId(1L);
        person.setCv("e1xydGYxXGFuc2kNCkxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0DQpccGFyIH0=");
        personRepository.save(person);
    }

    @Test
    public void test02(){
//        List<Person> persons = personRepository.query("ipsum");
        Iterable<Person> persons = personRepository.search(new QueryStringQueryBuilder("ipsum"));
        System.out.println(JSON.toJSONString(persons));
    }


    @Test
    public void test03() throws Exception {
        Person person = new Person();
        person.setId(2L);

//        File file = new File("/Users/lcssos/Documents/刘昌胜个人简历2016.docx");
//        login4.setIntroduction(encodeBase64File("/Users/lcssos/Documents/刘昌胜个人简历2016.docx"));
        person.setCv(encodeBase64File("/Users/lcssos/Documents/刘昌胜个人简历2016.docx"));
        personRepository.save(person);
    }

    @Test
    public void test04(){
//        List<Person> persons = personRepository.query("ipsum");
        Iterable<Person> persons = personRepository.search(new QueryStringQueryBuilder("北京科技大学"));
        System.out.println(JSON.toJSONString(persons));
    }


    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);;
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }



}
