package cn.javastack.springboot.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志控制器
 * 微信公众号：Java技术栈
 */
@Slf4j
@RestController
public class LogController {

    @GetMapping("/log/stacktrace/test")
    public String logStacktraceTest() {
        try {
            throw new RuntimeException("自定义结构化日志堆栈跟踪抛出异常！");
        } catch (Exception e) {
            log.error("自定义结构化日志堆栈跟踪异常", e);
        }
        return "ok";
    }

}
