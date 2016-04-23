import cn.martin.es.entity.Book;
import cn.martin.es.repository.BookRepository;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lcssos on 16/4/23.
 */
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:applicationContext-elasticsearch.xml"
})
public class BookRepositoryTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private BookRepository bookRepository;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test(){
        Book book = new Book();
        book.setId(3L);
        book.setName("寻秦记");
        bookRepository.save(book);
    }


    @Test
    public void test01(){
        Book book = bookRepository.findOne(4L);
        System.out.println(JSON.toJSONString(book));
    }

    @Test
    public void test02(){
        List<Book> books = bookRepository.findByNameLike("大唐");
        System.out.println(JSON.toJSONString(books));
    }


    @Test
    public void test03(){
        Book book = new Book();
        book.setId(4L);
        book.setName("凌渡宇");

        IndexQuery indexQuery = new IndexQueryBuilder().withId(String.valueOf(book.getId())).withObject(book).build();
        elasticsearchTemplate.index(indexQuery);

    }

}
