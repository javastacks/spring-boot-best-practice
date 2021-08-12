package cn.javastack.springboot.mapstruct.dto;

import lombok.Data;

/**
 * 微信公众号：Java技术栈
 * @author 栈长
 */
@Data
public class UserCustomDTO {

    private String name;

    private int sex;

    private boolean married;

    private String birthday;

    private String regDate;

    private UserExtDTO userExtDTO;

    private String memo;


}
