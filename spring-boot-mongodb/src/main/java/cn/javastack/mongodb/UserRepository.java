package cn.javastack.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 微信公众号：Java技术栈
 */
public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findByName(String name);

}

