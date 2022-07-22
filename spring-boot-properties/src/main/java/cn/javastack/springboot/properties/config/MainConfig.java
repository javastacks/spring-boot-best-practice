package cn.javastack.springboot.properties.config;

import cn.javastack.springboot.properties.props.OtherMember;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Profile("main")
@SpringBootConfiguration
@Import({Configuration1.class, Configuration2.class})
public class MainConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConfigurationProperties(prefix = "member")
    public OtherMember otherMember() {
        return new OtherMember();
    }

}
