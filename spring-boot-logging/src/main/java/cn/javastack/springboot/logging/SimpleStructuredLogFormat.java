package cn.javastack.springboot.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.boot.logging.structured.StructuredLogFormatter;

/**
 * 自定义结构化日志格式
 * 微信公众号：Java技术栈
 */
public class SimpleStructuredLogFormat implements StructuredLogFormatter<ILoggingEvent> {

    @Override
    public String format(ILoggingEvent event) {
        return "time=" + event.getInstant() + " level=" + event.getLevel() + " message=" + event.getMessage() + "\n";
    }

}