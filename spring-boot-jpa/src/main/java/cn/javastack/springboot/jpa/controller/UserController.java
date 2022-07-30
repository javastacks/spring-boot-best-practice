package cn.javastack.springboot.jpa.controller;

import cn.javastack.springboot.jpa.entity.UserDO;
import cn.javastack.springboot.jpa.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    public final UserRepository userRepository;

    @GetMapping("/user/info/{id}")
    public UserDO getUserInfo(@PathVariable("id") long id){
        UserDO userDO = userRepository.findById(id).orElseGet(null);
        return userDO;
    }

}