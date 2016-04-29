package cn.martin.es.repository;

import cn.martin.es.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by lcssos on 16/4/24.
 */
public interface PersonRepository extends ElasticsearchRepository<Person,Long> {

    List<Person> findByCvLike(String search);


}
