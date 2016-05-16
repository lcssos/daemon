package cn.martin.solr.repository;


import cn.martin.solr.entity.Book;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * Created by lcssos on 16/4/23.
 */
public interface BookRepository extends SolrCrudRepository<Book,Long> {

    Book save(Book book);

    List<Book> findByNameLike(String name);
}
