package cn.javastack.springboot.activemq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
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

    private final JmsTemplate jmsTemplate;

    /**
     * 发送消息
     * @param msg
     * @return
     */
    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg) {
        jmsTemplate.convertAndSend("test-queue", msg);
        return "已发送";
    }

    /**
     * 接收消息
     * @param msg
     */
    @JmsListener(destination = "test-queue")
    public void receiveMsg(String msg) {
        log.info("收到 ActiveMQ 消息：{}", msg);
    }

}
