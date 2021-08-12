package cn.javastack.springboot.mapstruct.entity;

import lombok.Data;

import java.util.Date;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@Data
public class UserNestedDO {

    private String name;

    private int sex;

    private int age;

    private Date birthday;

    private String phone;

    private boolean married;

    private Date regDate;

    private Date loginDate;

    private String memo;

    private UserExtDO userExtDO;

    private UserAddressDO userAddressDO;
    
}
