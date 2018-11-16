package cn.javastack.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/test/getUser")
    public ActResult getUserInfo(@RequestParam("username") String username) {
        ActResult actResult = new ActResult();
        actResult.setData(username);
        actResult.setMsg("javastack");
        return actResult;
    }

}
