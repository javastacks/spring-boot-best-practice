package cn.javastack.springboot.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 简单计划任务
 * 公众号：Java技术栈
 */
@Slf4j
@Component
public class SimpleTask {

    @Async
    @Scheduled(cron = "*/3 * * * * *")
    public void printTask() {
        log.info("这是一个简单的计划任务。");
    }

}
