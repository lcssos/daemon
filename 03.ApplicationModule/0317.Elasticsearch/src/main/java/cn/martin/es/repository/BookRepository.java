package cn.martin.es.repository;

import cn.martin.es.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * Created by lcssos on 16/4/23.
 */
public interface BookRepository extends ElasticsearchCrudRepository<Book,Long> {

//    Book save(Book book);

    List<Book> findByNameLike(String name);
}
