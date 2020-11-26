package cn.javastack.springboot.profile;

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

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Value("${db.name}")
    private String dbName;

    @Value("${mq.address}")
    private String mqAddress;

    @Value("${env}")
    private String env;

    @Value("${server.port}")
    private String port;

    @Bean
    public CommandLineRunner commandLineRunner(){
        return (args) -> {
            log.info("port is {}, db name is {}, mq address is {}, env is {}", port, dbName, mqAddress, env);
        };
    }

}
