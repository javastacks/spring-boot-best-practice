package cn.javastack.springboot.mybatisplus.service;

import cn.javastack.springboot.mybatisplus.entity.UserDO;
import cn.javastack.springboot.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl
        extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserDO getByUsername(String username, int type) {
        if (type == 0) {
            // xml
            log.info("query from xml");
            return userMapper.selectByUsername(username);
        } else {
            // QueryWrapper
            log.info("query from wrapper");
            LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(UserDO::getUsername, username);
            queryWrapper.eq(UserDO::getStatus, 1);
            return userMapper.selectOne(queryWrapper);
        }

    }

}