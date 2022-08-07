package cn.javastack.springboot.redis;

import cn.javastack.springboot.redis.pojo.User;
import cn.javastack.springboot.redis.service.RedisLockService;
import cn.javastack.springboot.redis.service.RedisOptService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@RestController
public class RedisController {

    private final StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valueOperations;

    private final RedisOptService redisOptService;
    private final RedisLockService redisLockService;

    @GetMapping("/redis/set")
    public String set(@RequestParam("name") String name, @RequestParam("value") String value) {
        valueOperations.set(name, value);
        return valueOperations.get(name);
    }

    @GetMapping("/redis/setObject")
    public String setObject(@RequestParam("name") String name) {
        User user = new User();
        user.setId(RandomUtils.nextInt());
        user.setName(name);
        user.setBirthday(new Date());

        List<String> list = new ArrayList<>();
        list.add("sing");
        list.add("run");
        user.setInteresting(list);

        Map<String, Object> map = new HashMap<>();
        map.put("hasHouse", "yes");
        map.put("hasCar", "no");
        map.put("hasKid", "no");
        user.setOthers(map);

        redisOptService.set(name, user, 30000);
        User userValue = (User) redisOptService.get(name);
        return userValue.toString();
    }

    @GetMapping("/redis/lock")
    public String lock(@RequestParam("key") String key) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                redisLockService.lock(key);
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                redisLockService.unlock(key);
            }
            ).start();
        }
        return "OK";
    }

    @GetMapping("/redis/sentinel/set")
    public String sentinelSet(@RequestParam("name") String name) {
        redisOptService.set("name", name, 60000);
        return redisOptService.getStringValue("name");
    }

}
