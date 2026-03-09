package cn.javastack.springboot.webflux.controller;

import cn.javastack.springboot.webflux.bean.User;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Rest Controller
 * 微信公众号：Java技术栈
 */
@Slf4j
@RestController
@Validated
public class ResponseBodyController {

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @CrossOrigin(origins = "https://javastack.cn", maxAge = 3600)
    @GetMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> getUserInfo(@PathVariable @Size(min = 5, max = 8) String userId) {
        User user = new User("Java技术栈", 18);
        user.setId(Long.valueOf(userId));
        return Mono.just(user);
    }

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<User>> users() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("Java技术栈", 10 + i);
            user.setId(Long.valueOf(i + 1));
            users.add(user);
        }
        return Mono.just(users);
    }

    /**
     * 获取用户列表（流式输出）
     * @return
     */
    @GetMapping(value = "/users/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> usersStream() {
        return Flux.range(1, 5)
                .map(i -> {
                    User user = new User("Java技术栈", 10 + i);
                    user.setId((long) i);
                    return user;
                })
                .delayElements(Duration.ofSeconds(1)); // 每隔1秒输出一个用户信息，模拟数据逐条产生
    }

    @PostMapping(value = "/user/save")
    public Mono<User> saveUser(@RequestBody @Validated User user) {
        user.setId(RandomUtils.nextLong());
        return Mono.just(user);
    }

}