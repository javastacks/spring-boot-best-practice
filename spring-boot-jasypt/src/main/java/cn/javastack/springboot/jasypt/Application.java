package cn.javastack.springboot.jasypt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 来源微信公众号：Java技术栈
 * 作者：栈长
 */
@Slf4j
@SpringBootApplication
public class Application {

    @Value("${javastack.username}")
    private String username;

    @Value("${javastack.password}")
    private String password;

    /**
     * 来源微信公众号：Java技术栈
     * 作者：栈长
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     * 来源微信公众号：Java技术栈
     * 作者：栈长
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            log.info("javastack.username = {}", username);
            log.info("javastack.password = {}", password);
        };
    }

}
