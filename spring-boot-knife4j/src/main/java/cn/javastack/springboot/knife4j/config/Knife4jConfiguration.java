package cn.javastack.springboot.knife4j.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * Knife4j 配置类
 * 来源微信公众号：Java技术栈
 * 作者：R哥
 */
@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact()
                .name("公众号：Java技术栈")
                .url("https://www.javastack.cn")
                .email("xx@javastack.cn");
        Info info = new Info()
                .title("Knife4j 测试")
                .description("Knife4j Test")
                .termsOfService("https://www.javastack.cn")
                .version("1.0")
                .contact(contact);
        return new OpenAPI().info(info);
    }

}
