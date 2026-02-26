package cn.javastack.springboot.admin.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 作者：R哥
 * 来源微信公众号：Java技术栈
 */
@Configuration
public class SecurityPermitAllConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http.authorizeHttpRequests((authorize) -> {
            authorize.anyRequest().permitAll();
        }).csrf(AbstractHttpConfigurer::disable).build();
    }

}