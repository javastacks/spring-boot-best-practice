package cn.javastack.springboot.restservices.controller;

import cn.javastack.springboot.restservices.bean.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API 版本控制
 * 微信公众号：Java技术栈
 */
@Slf4j
@RestController
@RequestMapping(value = {
        "/account/{id}",
//        "/account/{id}/{version}"
})
public class AccountController {

    private static Account createAccount(String version) {
        Account account = new Account(1L, Account.ACCOUNT_DEFAULT_NAME, Account.ACCOUNT_DEFAULT_SITE, version);
        return account;
    }

    // 1、匹配任意版本
    @GetMapping
    public Account getAccount() {
        log.info("getAccount...");
        return createAccount("any");
    }

    // 2、匹配版本 1.1
    @GetMapping(version = "1.1")
    public Account getAccount1_1() {
        log.info("getAccount1.1...");
        return createAccount("1.1");
    }

    // 3、匹配版本 1.2+
    @GetMapping(version = "1.2+")
    public Account getAccount1_2() {
        log.info("getAccount1.2+...");
        return createAccount("1.2+");
    }

    // 4、匹配版本 1.5
    @GetMapping(version = "1.5")
    public Account getAccount1_5() {
        log.info("getAccount1_5...");
        return createAccount("1.5");
    }

}