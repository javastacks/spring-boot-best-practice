package cn.javastack.springboot.quartz;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 任务配置
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@Configuration
public class TaskConfig {

    public static final String SIMPLE_TASK = "simple-task";
    private final SchedulerFactoryBean schedulerFactoryBean;

    /**
     * 动态添加任务
     * @throws SchedulerException
     */
    @PostConstruct
    public void init() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        boolean exists = scheduler.checkExists(JobKey.jobKey(SIMPLE_TASK));
        if (!exists) {
            scheduler.scheduleJob(simpleTask(), simpleTaskTrigger());
        }
    }

    //    @Bean
    public JobDetail simpleTask() {
        return JobBuilder.newJob(SimpleTask.class)
                .withIdentity(SIMPLE_TASK)
                .withDescription("简单任务")
                .storeDurably()
                .build();
    }

    //    @Bean
    public Trigger simpleTaskTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");
        return TriggerBuilder.newTrigger()
                .withIdentity("simple-task-trigger")
                .forJob(simpleTask())
                .withSchedule(cronScheduleBuilder)
                .build();
    }

}