package cn.javastack.springboot.mybatisplus.service;

import cn.javastack.springboot.mybatisplus.entity.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 微信公众号：Java技术栈
 */
public interface UserService extends IService<UserDO> {

    UserDO getByUsername(String username, int type);

}