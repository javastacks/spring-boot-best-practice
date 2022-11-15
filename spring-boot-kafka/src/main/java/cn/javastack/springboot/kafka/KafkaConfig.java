package cn.javastack.springboot.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信公众号：Java技术栈
 */
@Configuration
public class KafkaConfig {

    public static final String SPRING_BOOT_TEST_TOPIC = "spring-boot-test-topic";

    @Bean
    public NewTopic testTopic() {
        return new NewTopic(SPRING_BOOT_TEST_TOPIC, 4, (short) 1);
    }

}