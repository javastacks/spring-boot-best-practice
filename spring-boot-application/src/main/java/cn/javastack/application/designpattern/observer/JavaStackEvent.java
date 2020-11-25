package cn.javastack.application.designpattern.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 观察目标：栈长
 * 来源微信公众号：Java技术栈
 */
@Getter
public class JavaStackEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public JavaStackEvent(Object source) {
        super(source);
    }


}
