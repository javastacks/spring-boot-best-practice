package cn.javastack.springboot.schedule;

import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Duration;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskConfig {

    @Lazy
    @Bean
    @Primary
    public ThreadPoolTaskExecutor taskExecutor1(TaskExecutionProperties taskExecutionProperties) {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        PropertyMapper map = PropertyMapper.get().alwaysApplyingWhenNonNull();
        TaskExecutionProperties.Pool pool = taskExecutionProperties.getPool();
        map.from(pool::getQueueCapacity).to(taskExecutor::setQueueCapacity);
        map.from(pool::getCoreSize).to(taskExecutor::setCorePoolSize);
        map.from(pool::getMaxSize).to(taskExecutor::setMaxPoolSize);
        map.from(pool::getKeepAlive).asInt(Duration::getSeconds).to(taskExecutor::setKeepAliveSeconds);
        map.from(pool::isAllowCoreThreadTimeout).to(taskExecutor::setAllowCoreThreadTimeOut);
        map.from("my-task1-").whenHasText().to(taskExecutor::setThreadNamePrefix);

        // 默认不设置就是 AbortPolicy
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        return taskExecutor;
    }

    @Lazy
    @Bean
    public ThreadPoolTaskExecutor taskExecutor2(TaskExecutionProperties taskExecutionProperties) {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        PropertyMapper map = PropertyMapper.get().alwaysApplyingWhenNonNull();
        TaskExecutionProperties.Pool pool = taskExecutionProperties.getPool();
        map.from(10).to(taskExecutor::setQueueCapacity);
        map.from(3).to(taskExecutor::setCorePoolSize);
        map.from(5).to(taskExecutor::setMaxPoolSize);
        map.from(20).to(taskExecutor::setKeepAliveSeconds);
        map.from(true).to(taskExecutor::setAllowCoreThreadTimeOut);
        map.from("my-task2-").whenHasText().to(taskExecutor::setThreadNamePrefix);

        return taskExecutor;
    }


}
