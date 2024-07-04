package cn.javastack.springboot.web.controller;

import cn.javastack.springboot.web.bean.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/restTemplate/{uid}")
    public User restTemplate(@PathVariable("uid") String uid) {
        return this.restTemplate.getForObject(GET_USERINFO_URL, User.class, uid);
    }

    @GetMapping("/restClient/{uid}")
    public User restClient(@PathVariable("uid") String uid) {
        return this.restClient
                .get()
                .uri("/user/json/{uid}", uid)
                .retrieve()
                .body(User.class);
    }

}
