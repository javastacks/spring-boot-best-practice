package cn.javastack.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登录接口
 * 微信公众号：Java技术栈
 */
@Slf4j
@Controller
public class LoginController {


    @GetMapping("/logout")
    public void logout() {
        log.info("log out...");
    }

}
