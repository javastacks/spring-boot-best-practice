package cn.javastack.springboot.starter.sample;

import cn.javastack.springboot.starter.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@SpringBootApplication
public class Application {

    @Value("${debug}")
    private boolean debug;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TestService testService) {
        return (args) -> {
            log.info("debug mode: {}", debug);
            log.info(testService.getServiceName());
        };
    }

}
