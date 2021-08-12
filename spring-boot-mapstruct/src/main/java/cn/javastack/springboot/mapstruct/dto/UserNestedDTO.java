package cn.javastack.springboot.mapstruct.dto;

import lombok.Data;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@Data
public class UserNestedDTO {

    private String name;

    private int sex;

    private boolean married;

    private String birthday;

    private String regDate;

    private String regSource;

    private String favorite;

    private String school;

    private String city;

    private String address;

    private String memo;

}
