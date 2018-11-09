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
        SpringApplication.run(Application.class);
    }

    private static final org.apache.commons.logging.Log logger1 = org.apache.commons.logging
            .LogFactory
            .getLog(Application.class);

    private static final org.slf4j.Logger logger2 = org.slf4j.LoggerFactory
            .getLogger(Application.class);

    private static final java.util.logging.Logger logger3 = java.util.logging.Logger
            .getLogger("Application");

    @Bean
    public CommandLineRunner loggerLineRunner() {
        return (args) -> {
            logger1.error("commons logging error...");
            logger1.info("commons logging info...");
            logger1.debug("commons logging debug...");

            logger2.info("slf4j info...");

            logger2.info("java util logging info...");
        };
    }

}
