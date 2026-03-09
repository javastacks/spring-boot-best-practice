package cn.javastack.springboot.webflux.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
