package cn.javastack.springboot.properties.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Slf4j
public class Configuration1 {

    @Bean
    public CommandLineRunner clr1() {
        return (args) -> {
            log.info("Configuration1 commandLineRunner");
        };
    }

}
