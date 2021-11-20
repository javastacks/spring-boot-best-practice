package cn.javastack.springboot.features;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
@RestController
public class Application {

    /**
     * 作者：栈长
     * 来源微信公众号：Java技术栈
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);

        // 允许循环引用
        application.setAllowCircularReferences(true);
        application.run(args);
    }


    /**
     * 作者：栈长
     * 来源微信公众号：Java技术栈
     */
//    @Bean
//    public CommandLineRunner commandLineRunner(){
//        throw new JavastackException("Java技术栈异常");
//    }

}
