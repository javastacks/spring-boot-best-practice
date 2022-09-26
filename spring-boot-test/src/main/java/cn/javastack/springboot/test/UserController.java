package cn.javastack.springboot.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@RestController
public class UserController {

    @GetMapping(value = "/user/get")
    public Result getUserInfo(@RequestParam("username") String username) {
        Result result = new Result();
        result.setData(username);
        result.setMsg("ok");
        return result;
    }

}
