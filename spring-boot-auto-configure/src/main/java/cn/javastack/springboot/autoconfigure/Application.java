package cn.javastack.springboot.autoconfigure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EnvConfig envConfig) {
        return (args) -> {
            System.out.println(envConfig.getStringValue("user.alias"));
            System.out.println(envConfig.getIntValue("user.age"));
        };
    }

}
