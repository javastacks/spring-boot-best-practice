package cn.javastack.springboot.graalvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    @RequestMapping("/hi")
    String hello() {
        return "Hello GraalVM!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}