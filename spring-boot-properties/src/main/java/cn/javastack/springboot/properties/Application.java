package cn.javastack.springboot.properties;

import cn.javastack.springboot.properties.props.DbProperties;
import cn.javastack.springboot.properties.props.JavastackProperties;
import cn.javastack.springboot.properties.props.MemberProperties;
import cn.javastack.springboot.properties.props.OtherMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;


/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
@RequiredArgsConstructor
//@EnableConfigurationProperties(value = {JavastackProperties.class, MemberProperties.class})
@ConfigurationPropertiesScan
@Slf4j
public class Application {

    private final DbProperties dbProperties;

    private final JavastackProperties javastackProperties;

    private final MemberProperties memberProperties;

    private final OtherMember otherMember;

    @Value("${server.port}")
    private int serverPort;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.setAdditionalProfiles("dev", "main");
        springApplication.run(args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            log.info("db properties: {}", dbProperties);
            log.info("javastack properties: {}", javastackProperties);
            log.info("member properties: {}", memberProperties);
            log.info("other member: {}", otherMember);
            log.info("server.port: {}", serverPort);
        };
    }

}
