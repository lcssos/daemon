import cn.martin.solr.entity.Book;
import cn.martin.solr.repository.BookRepository;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lcssos on 16/5/1.
 */
@ContextConfiguration(locations = {
        "classpath:applicationContext-solr.xml"
})
public class BookRepositoryTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private BookRepository bookRepository;

    @Test
    public void test01(){
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("倚天屠龙记");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setName("雪山飞狐");
        bookRepository.save(book2);
    }


    @Test
    public void test02(){
        List<Book> bookList = bookRepository.findByNameLike("雪山");
        System.out.println(JSON.toJSONString(bookList));
    }
}
