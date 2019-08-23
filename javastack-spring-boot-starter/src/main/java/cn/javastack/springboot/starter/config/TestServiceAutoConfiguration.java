package cn.javastack.springboot.starter.config;

import cn.javastack.springboot.starter.service.TestService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "javastack.starter", name = "enabled", havingValue = "true")
public class TestServiceAutoConfiguration {

    @Bean
    public TestService testService() {
        return new TestService();
    }

}
