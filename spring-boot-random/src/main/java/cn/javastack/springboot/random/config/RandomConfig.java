package cn.javastack.springboot.random.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 微信公众号：Java技术栈
 */
@Component
@ConfigurationProperties(prefix = "user.random")
@PropertySource(value = {"random.properties"})
@Data
public class RandomConfig {

    private String secret;
    private int intNumber;
    private int lessTen;
    private int range;
    private long longNumber;
    private String uuid;

}