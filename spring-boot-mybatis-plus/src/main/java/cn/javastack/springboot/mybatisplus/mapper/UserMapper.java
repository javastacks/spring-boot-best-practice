package cn.javastack.springboot.mybatisplus.mapper;

import cn.javastack.springboot.mybatisplus.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 微信公众号：Java技术栈
 */
public interface UserMapper extends BaseMapper<UserDO> {

    UserDO selectByUsername(@Param("username") String username);

}