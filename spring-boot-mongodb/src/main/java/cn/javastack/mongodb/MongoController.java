package cn.javastack.mongodb;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@RestController
public class MongoController {

    public static final String COLLECTION_NAME = "javastack";
    private final MongoTemplate mongoTemplate;

    private final UserRepository userRepository;

    @RequestMapping("/mongo/insert")
    public User insert(@RequestParam("name") String name, @RequestParam("sex") int sex) {
        // 新增
        User user = new User(RandomUtils.nextInt(), name, sex);
        mongoTemplate.insert(user, COLLECTION_NAME);

        // 查询
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, User.class, COLLECTION_NAME);
    }

    @RequestMapping("/mongo/repo/insert")
    public User repoInsert(@RequestParam("name") String name, @RequestParam("sex") int sex) {
        // 新增
        User user = new User(RandomUtils.nextInt(), name, sex);
        userRepository.save(user);

        // 查询
        return userRepository.findByName(name).get(0);
    }

}
