package cn.javastack.springboot.es;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@RestController
public class EsController {

    public static final String INDEX_JAVASTACK = "javastack1";
    private final ElasticsearchTemplate elasticsearchTemplate;

    private final UserRepository userRepository;

    @RequestMapping("/es/insert")
    public User insert(@RequestParam("name") String name, @RequestParam("sex") int sex) throws InterruptedException {
        // 新增
        User user = new User(RandomUtils.nextInt(), name, sex);
        IndexCoordinates indexCoordinates =  IndexCoordinates.of(INDEX_JAVASTACK);
        User save = elasticsearchTemplate.save(user, indexCoordinates);

        // 可能有延迟，休眠一秒再查询
        Thread.sleep(1000l);
        Query query = new CriteriaQuery(Criteria.where("name").is(name));
        return elasticsearchTemplate.searchOne(query, User.class, indexCoordinates).getContent();
    }

    @RequestMapping("/es/repo/insert")
    public User repoInsert(@RequestParam("name") String name, @RequestParam("sex") int sex) {
        // 新增
        User user = new User(RandomUtils.nextInt(), name, sex);
        userRepository.save(user);

        // 查询
        return userRepository.findByName(name).get(0);
    }

}
