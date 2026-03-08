package cn.javastack.springboot.restservices;

import cn.javastack.springboot.restservices.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

/**
 * 作者：R哥
 * 微信公众号：Java技术栈
 */
//@ImportHttpServices(basePackages = "cn.javastack.springboot.restservices.service")
@ImportHttpServices(group = "account", types = AccountService.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
