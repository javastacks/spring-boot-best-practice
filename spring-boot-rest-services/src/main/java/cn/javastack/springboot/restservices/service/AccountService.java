package cn.javastack.springboot.restservices.service;

import cn.javastack.springboot.restservices.bean.Account;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * HTTP 服务接口
 * 微信公众号：Java技术栈
 */
@HttpExchange(url = "/account/{uid}")
public interface AccountService {

    @GetExchange
    Account getAccount(@PathVariable Long uid);

}