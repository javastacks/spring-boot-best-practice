package cn.javastack.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@Controller
public class ErrorPageController implements ErrorController {

    @GetMapping(value = "/error")
    public String handleError() {
        return "redirect:/";
    }

}