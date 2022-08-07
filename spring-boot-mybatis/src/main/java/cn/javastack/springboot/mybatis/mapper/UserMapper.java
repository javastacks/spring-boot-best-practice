package cn.javastack.springboot.mybatis.mapper;


import cn.javastack.springboot.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 微信公众号：Java技术栈
 */
@Mapper
public interface UserMapper {

    UserDO findById(@Param("id") long id);

}




