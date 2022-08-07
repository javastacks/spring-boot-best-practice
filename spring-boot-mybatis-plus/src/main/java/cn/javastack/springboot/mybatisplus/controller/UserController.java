package cn.javastack.springboot.mybatisplus.controller;

import cn.javastack.springboot.mybatisplus.entity.UserDO;
import cn.javastack.springboot.mybatisplus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user/info/{id}")
    public UserDO getUserInfoById(@PathVariable("id") long id) {
        UserDO userDO = userService.getById(id);
        return userDO;
    }


    @GetMapping("/user/info")
    public UserDO getUserInfoByUsername(@RequestParam("username") String username,
                                        @RequestParam("type") int type) {
        UserDO userDO = userService.getByUsername(username, type);
        return userDO;
    }


}