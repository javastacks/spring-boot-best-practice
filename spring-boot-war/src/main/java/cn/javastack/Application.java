package cn.javastack;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
@RestController
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return startBuilder(builder);
    }

    public static void main(String[] args) {
        startBuilder(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder startBuilder(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello world.";
    }

}
