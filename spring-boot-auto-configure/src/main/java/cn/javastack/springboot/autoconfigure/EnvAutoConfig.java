package cn.javastack.springboot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertyResolver;

/**
 * 微信公众号：Java技术栈
 */
@Configuration
@ConditionalOnClass(PropertyResolver.class)
public class EnvAutoConfig {

    @Bean
    public EnvConfig envConfig() {
        return new EnvConfig();
    }

}