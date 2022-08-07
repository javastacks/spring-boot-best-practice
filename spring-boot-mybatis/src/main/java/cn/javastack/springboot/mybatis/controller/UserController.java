package cn.javastack.springboot.mybatis.controller;

import cn.javastack.springboot.mybatis.entity.UserDO;
import cn.javastack.springboot.mybatis.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserMapper userMapper;

    @GetMapping("/user/info/{id}")
    public UserDO getUserInfo(@PathVariable("id") long id) {
        UserDO userDO = userMapper.findById(id);
        return userDO;
    }

}