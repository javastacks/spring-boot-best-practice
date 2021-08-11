package cn.javastack.springboot.mapstruct.struct;

import cn.javastack.springboot.mapstruct.dto.UserShowDTO;
import cn.javastack.springboot.mapstruct.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@Mapper
public interface UserStruct {

    UserStruct INSTANCE = Mappers.getMapper(UserStruct.class);

    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(user.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userExt.regSource", target = "registerSource")
    @Mapping(source = "userExt.favorite", target = "favorite")
    @Mapping(target = "memo", ignore = true)
    UserShowDTO toUserShowDTO(User user);

    List<UserShowDTO> toUserShowDTOs(List<User> users);

}
