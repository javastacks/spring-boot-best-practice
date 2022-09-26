package cn.javastack.springboot.test.service;

import org.springframework.stereotype.Service;

/**
 * 微信公众号：Java技术栈
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public int countAllUsers() {
        return 10;
    }

}
