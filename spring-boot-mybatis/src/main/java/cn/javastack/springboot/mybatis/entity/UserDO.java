package cn.javastack.springboot.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String phone;

    private Date createTime;

    private Integer status;

}