package cn.javastack.application.designpattern.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ObserverConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return (args) -> {
            log.info("发布事件：什么是观察者模式？");
            context.publishEvent(new JavaStackEvent("什么是观察者模式？"));
        };
    }

    @Bean
    public ReaderListener readerListener1(){
        return new ReaderListener("小明");
    }

    @Bean
    public ReaderListener readerListener2(){
        return new ReaderListener("小张");
    }

    @Bean
    public ReaderListener readerListener3(){
        return new ReaderListener("小爱");
    }

}
