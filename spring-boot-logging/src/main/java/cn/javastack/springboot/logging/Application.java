package cn.javastack.springboot.logging;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("LOG_PATH", "./logs");
        System.setProperty("LOGBACK_ROLLINGPOLICY_MAX_FILE_SIZE", "1KB");
        SpringApplication.run(Application.class);
    }

    private static final org.apache.commons.logging.Log logger1 = org.apache.commons.logging
            .LogFactory
            .getLog(Application.class);

    private static final org.slf4j.Logger logger2 = org.slf4j.LoggerFactory
            .getLogger(Application.class);

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            logger1.error("commons logging error...");
            logger1.warn("commons logging warn");
            logger1.info("commons logging info...");
            logger1.debug("commons logging debug...");

            logger2.error("slf4j error...");
            logger2.warn("commons logging warn");
            logger2.info("slf4j info...");
            logger2.debug("slf4j debug...");
        };
    }

}
