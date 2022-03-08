package cn.javastack.springboot.tinylog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tinylog.Logger;

/**
 * 作者：栈长
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            Logger.info("hello, tinylog!");
        };
    }

}
