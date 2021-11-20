package cn.javastack.springboot.features.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：栈长
 * 来源微信公众号：Java技术栈
 */
@Service
public class UserService {

    @Autowired
    LogService logService;

}