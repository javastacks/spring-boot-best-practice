package cn.javastack.springboot.restservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;

/**
 * HTTP 服务分组配置类
 */
@Configuration
public class HttpServiceGroupConfiguration {

    @Bean
    RestClientHttpServiceGroupConfigurer restClientHttpServiceGroupConfigurer() {
        return (groups) -> groups.forEachClient((group, clientBuilder) -> {
            String groupName = group.name();
            clientBuilder.defaultHeader("service-group", groupName);
        });
    }

}