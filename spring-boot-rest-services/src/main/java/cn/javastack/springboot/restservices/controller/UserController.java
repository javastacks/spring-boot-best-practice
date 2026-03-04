package cn.javastack.springboot.restservices.controller;

import cn.javastack.springboot.restservices.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller
 * 微信公众号：Java技术栈
 */
@Slf4j
@RestController
@Validated
public class UserController {

    @CrossOrigin
    @GetMapping(value = "/user/json/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getJsonUserInfo(@PathVariable String userId) {
        User user = new User("Java技术栈", 18);
        user.setId(Long.valueOf(userId));
        log.info("user info: {}", user);
        return user;
    }

}
