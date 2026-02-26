package cn.javastack.springboot.mapstruct.entity;

import lombok.Data;

/**
 * 微信公众号：Java技术栈
 * @author R哥
 */
@Data
public class UserAddressDO {

    private String province;

    private String city;

    private String postcode;

    private String address;

    private String memo;

}
