package cn.javastack.springboot.actuator.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 微信公众号：Java技术栈
 */
@Data
@AllArgsConstructor
public class User {

    private int id;

    private String name;

    private int age;

}