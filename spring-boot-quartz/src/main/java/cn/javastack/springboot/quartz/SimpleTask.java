package cn.javastack.springboot.quartz;


import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 简单 Quartz 计划任务
 * 公众号：Java技术栈
 */
@Slf4j
public class SimpleTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("这是一个简单的 Quartz 计划任务。");
    }

}