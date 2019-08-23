package cn.javastack.springboot.starter.sample;

import cn.javastack.springboot.starter.service.TestService;
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
    public CommandLineRunner commandLineRunner(TestService testService) {
        return (args) -> {
            System.out.println(testService.getServiceName());
        };
    }

}
