package cn.javastack.springboot.restservices.controller;

import cn.javastack.springboot.restservices.bean.Account;
import cn.javastack.springboot.restservices.bean.User;
import cn.javastack.springboot.restservices.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
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
    private final RestTemplate restTemplate;

    private final RestClient restClient;

    private final WebClient webClient;

    private final AccountService accountService;

    @GetMapping("/restTemplate/{uid}")
    public User restTemplate(@PathVariable String uid) {
        return this.restTemplate.getForObject(GET_USERINFO_URL, User.class, uid);
    }

    @GetMapping("/restClient/{uid}")
    public User restClient(@PathVariable String uid) {
        return this.restClient
                .get()
                .uri("/user/json/{uid}", uid)
                .retrieve()
                .body(User.class);
    }

    @GetMapping("/webClient/{uid}")
    public Mono<User> webClient(@PathVariable String uid) {
        return this.webClient.get().uri(GET_USERINFO_URL, uid)
                .retrieve().bodyToMono(User.class);
    }

    @GetMapping("/getAccount/{uid}")
    public Account httpClient(@PathVariable Long uid) {
        return this.accountService.getAccount(uid);
    }

}
