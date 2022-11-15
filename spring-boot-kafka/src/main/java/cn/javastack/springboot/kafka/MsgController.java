package cn.javastack.springboot.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class MsgController {

    private final KafkaTemplate kafkaTemplate;

    /**
     * 发送消息
     * @param msg
     * @return
     */
    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg) {
        kafkaTemplate.send(KafkaConfig.SPRING_BOOT_TEST_TOPIC, "test-key", msg);
        return "已发送";
    }

    /**
     * 接收消息
     * @param msg
     */
    @KafkaListener(topics = KafkaConfig.SPRING_BOOT_TEST_TOPIC)
    public void receiveMsg(String msg) {
        log.info("收到 Kafka 消息：{}", msg);
    }

}
