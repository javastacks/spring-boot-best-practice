package cn.javastack.springboot.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 微信公众号：Java技术栈
 */
public interface UserRepository extends ElasticsearchRepository<User, Long> {

    List<User> findByName(String name);

}

