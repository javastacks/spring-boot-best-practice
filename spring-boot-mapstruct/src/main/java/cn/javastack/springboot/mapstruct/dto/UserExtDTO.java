package cn.javastack.springboot.mapstruct.dto;

import lombok.Data;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@Data
public class UserExtDTO {

    private String regSource;

    private String favorite;

    private String school;

    private int kids;

    private String memo;

}
