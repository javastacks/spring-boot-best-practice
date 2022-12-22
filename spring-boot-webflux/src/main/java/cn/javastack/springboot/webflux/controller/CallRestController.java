package cn.javastack.springboot.webflux.controller;

import cn.javastack.springboot.webflux.bean.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Rest 服务调用接口
 * 微信公众号：Java技术栈
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CallRestController {

    public static final String GET_USERINFO_URL = "http://localhost:8080/user/json/{uid}";

    private final WebClient webClient;

    @GetMapping("/webClient/{uid}")
    public Mono<User> webClient(@PathVariable("uid") String uid) {
        return this.webClient.get().uri(GET_USERINFO_URL, uid)
                .retrieve().bodyToMono(User.class);
    }

}
