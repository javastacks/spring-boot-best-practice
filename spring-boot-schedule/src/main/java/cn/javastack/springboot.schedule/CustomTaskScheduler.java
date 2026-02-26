package cn.javastack.springboot.schedule;

import lombok.Getter;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * 自定义任务调度
 * 公众号：Java技术栈
 */
@Component
class CustomTaskScheduler extends ThreadPoolTaskScheduler {

    @Getter
    private final Map<Object, ScheduledFuture<?>> scheduledTasks = new IdentityHashMap<>();

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Trigger trigger) {
        ScheduledFuture<?> future = super.schedule(task, trigger);
        this.putScheduledTasks(task, future);
        return future;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Duration period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, period);
        this.putScheduledTasks(task, future);
        return future;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Instant startTime, Duration period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, startTime, period);
        this.putScheduledTasks(task, future);
        return future;
    }

    private void putScheduledTasks(Runnable task, ScheduledFuture<?> future) {
        Object taskKey = resolveTaskKey(task);
        scheduledTasks.put(taskKey, future);
    }

    private Object resolveTaskKey(Runnable task) {
        ScheduledMethodRunnable scheduledMethodRunnable = findScheduledMethodRunnable(task);
        return scheduledMethodRunnable != null ? scheduledMethodRunnable.getTarget() : task;
    }

    private ScheduledMethodRunnable findScheduledMethodRunnable(Runnable task) {
        Runnable current = task;
        int depth = 0;
        while (current != null && depth++ < 10) {
            if (current instanceof ScheduledMethodRunnable scheduledMethodRunnable) {
                return scheduledMethodRunnable;
            }
            Runnable unwrapped = unwrapRunnable(current);
            if (unwrapped == null || unwrapped == current) {
                return null;
            }
            current = unwrapped;
        }
        return null;
    }

    private Runnable unwrapRunnable(Runnable runnable) {
        Runnable candidate = getRunnableFieldValue(runnable, "runnable");
        if (candidate != null) {
            return candidate;
        }
        candidate = getRunnableFieldValue(runnable, "delegate");
        if (candidate != null) {
            return candidate;
        }
        candidate = getRunnableFieldValue(runnable, "task");
        if (candidate != null) {
            return candidate;
        }

        for (Field field : runnable.getClass().getDeclaredFields()) {
            if (Runnable.class.isAssignableFrom(field.getType())) {
                try {
                    ReflectionUtils.makeAccessible(field);
                    Object value = ReflectionUtils.getField(field, runnable);
                    if (value instanceof Runnable candidateRunnable) {
                        return candidateRunnable;
                    }
                } catch (RuntimeException ignored) {
                    // ignore and continue
                }
            }
        }
        return null;
    }

    private Runnable getRunnableFieldValue(Runnable task, String fieldName) {
        Field field = ReflectionUtils.findField(task.getClass(), fieldName);
        if (field == null || !Runnable.class.isAssignableFrom(field.getType())) {
            return null;
        }
        try {
            ReflectionUtils.makeAccessible(field);
            Object value = ReflectionUtils.getField(field, task);
            return value instanceof Runnable runnable ? runnable : null;
        } catch (RuntimeException ignored) {
            return null;
        }
    }

    // 重写所有 schedule* 方法...

}
