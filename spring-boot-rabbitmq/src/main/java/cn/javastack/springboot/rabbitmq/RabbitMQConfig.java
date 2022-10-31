package cn.javastack.springboot.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信公众号：Java技术栈
 */
@Configuration
public class RabbitMQConfig {

    /**
     * 创建 Direct 模式队列
     * @return
     */
    @Bean
    public Queue testDirectQueue() {
        return new Queue("test-direct-queue");
    }

    /**
     * 创建 Direct 模式交换器
     * @return
     */
    @Bean
    public DirectExchange TestDirectExchange() {
        return new DirectExchange("test-direct-exchange");
    }

    /**
     * 创建 Direct 队列与交换器绑定
     * @param testDirectQueue
     * @return
     */
    @Bean
    public Binding testDirectBinding(Queue testDirectQueue) {
        return BindingBuilder.bind(testDirectQueue)
                .to(TestDirectExchange()).with("test-direct-routing-key");
    }

}