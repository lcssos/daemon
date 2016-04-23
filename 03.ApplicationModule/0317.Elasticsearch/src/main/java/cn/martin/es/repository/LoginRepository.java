package cn.martin.es.repository;

import cn.martin.es.entity.Login;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * Created by lcssos on 16/4/23.
 */
public interface LoginRepository extends ElasticsearchCrudRepository<Login,Long> {

    List<Login> findByCommentsLike(String name);

    Login findByUuid(Long uuid);

}
