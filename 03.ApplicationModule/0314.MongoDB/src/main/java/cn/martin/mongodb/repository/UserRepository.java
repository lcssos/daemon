//package cn.martin.mongodb.repository;
//
//import cn.martin.mongodb.entity.User;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
///**
// * Created by lcssos on 16/3/30.
// */
//public interface UserRepository extends CrudRepository<User, Long> {
//
//    Long countByLastname(String lastname);
//    Long deleteByLastname(String lastname);
//    List<User> removeByLastname(String lastname);
//
//
//    List<User> findByLastname(String lastname);
//}
