package cn.javastack.springboot.features;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
@RestController
@Slf4j
public class Application {

    /**
     * 作者：栈长
     * 来源微信公众号：Java技术栈
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);

        // 允许循环引用
        springApplication.setAllowCircularReferences(true);

        // 启动详细日志
        springApplication.setLogStartupInfo(true);

        // 图案输出模式
        springApplication.setBannerMode(Banner.Mode.CONSOLE);

        springApplication.run(args);
    }

    /**
     * 作者：栈长
     * 来源微信公众号：Java技术栈
     */
    @Bean
    @Order(500)
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
//            throw new JavastackException("Java技术栈异常");
        };
    }

}
