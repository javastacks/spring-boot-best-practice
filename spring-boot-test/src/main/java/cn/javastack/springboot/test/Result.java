package cn.javastack.springboot.test;

import lombok.Data;

/**
 * 微信公众号：Java技术栈
 */
@Data
public class Result {

    private int code = 0;

    private String msg;

    private Object data;

}