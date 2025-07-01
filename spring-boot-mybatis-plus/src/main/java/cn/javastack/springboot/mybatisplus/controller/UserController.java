package cn.javastack.springboot.mybatisplus.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.javastack.springboot.mybatisplus.entity.UserDO;
import cn.javastack.springboot.mybatisplus.service.UserService;
import lombok.RequiredArgsConstructor;

/**
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/add-user")
    public String addUserPage() {
        return "add-user";
    }

    @GetMapping("/search-user")
    public String searchUserPage() {
        return "search-user";
    }

    @ResponseBody
    @GetMapping("/users/{id}")
    public UserDO getUserInfoById(@PathVariable("id") long id) {
        return userService.getById(id);
    }

    @ResponseBody
    @GetMapping("/users")
    public UserDO getUserInfoByUsername(@RequestParam("username") String username,
                                        @RequestParam("type") int type) {
        return userService.getByUsername(username, type);
    }

    @ResponseBody
    @PostMapping("/users")
    public UserDO createUser(@RequestBody UserDO user) {
        user.setCreateTime(LocalDateTime.now());
        if (user.getStatus() == null) {
            user.setStatus(1);
        }
        userService.save(user);
        return user;
    }

}