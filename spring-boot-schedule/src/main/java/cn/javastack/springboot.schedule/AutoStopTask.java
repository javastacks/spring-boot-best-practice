package cn.javastack.springboot.schedule;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * 按条件自动停止任务
 * 公众号：Java技术栈
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AutoStopTask {

    private final CustomTaskScheduler customTaskScheduler;

    private int count;

    @Scheduled(cron = "*/3 * * * * *")
    public void printTask() {
        log.info("公众号Java技术栈，任务执行次数：{}", count + 1);

        count++;

        // 执行3次后自动停止
        if (count >= 3) {
            log.info("任务已执行指定次数，现在自动停止");
            boolean cancelled = customTaskScheduler.getScheduledTasks().get(this).cancel(true);
            if (cancelled) {
                count = 0;
                ScheduledMethodRunnable runnable = new ScheduledMethodRunnable(this, ReflectionUtils.findMethod(this.getClass(), "printTask"));
                customTaskScheduler.schedule(runnable, new CronTrigger("*/3 * * * * *"));
            }
        }
    }

}
