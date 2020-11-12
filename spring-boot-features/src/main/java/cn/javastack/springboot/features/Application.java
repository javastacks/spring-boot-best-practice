package cn.javastack.springboot.features;

import cn.javastack.springboot.features.analyzer.JavastackException;
import cn.javastack.springboot.features.listener.JavastackListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.addListeners(new JavastackListener());
        springApplication.run(Application.class);
    }


    /**
     * 来源微信公众号：Java技术栈
     */
//    @Bean
//    public CommandLineRunner commandLineRunner(){
//        throw new JavastackException("Java技术栈异常");
//    }

}
