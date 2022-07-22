package cn.javastack.springboot.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@ServletComponentScan
@SpringBootApplication
@Controller
public class Application {

    private final HttpServletRequest request;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @GetMapping(value = "/test/{content}")
    public String test(@PathVariable("content") String content) {
        request.setAttribute("content", content);
        return "test";
    }


}
