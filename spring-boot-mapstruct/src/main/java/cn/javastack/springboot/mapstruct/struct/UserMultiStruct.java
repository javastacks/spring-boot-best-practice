package cn.javastack.springboot.mapstruct.struct;

import cn.javastack.springboot.mapstruct.dto.UserMultiDTO;
import cn.javastack.springboot.mapstruct.entity.UserAddressDO;
import cn.javastack.springboot.mapstruct.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@Mapper(componentModel = "spring")
public interface UserMultiStruct {

    @Mapping(source = "userDO.birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "userDO.regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(userDO.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userAddressDO.postcode", target = "postcode")
    @Mapping(source = "userAddressDO.address", target = "address")
    @Mapping(target = "memo", ignore = true)
    UserMultiDTO toUserMultiDTO(UserDO userDO, UserAddressDO userAddressDO);

}
