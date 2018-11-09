package cn.javastack.springboot.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @GetMapping(value = "/user/json/{userId}")
    public User getUserInfo(@PathVariable("userId") String userId) {
        User user = new User("Java技术栈", 18);
        user.setId(Long.valueOf(userId));
        return user;
    }

}
