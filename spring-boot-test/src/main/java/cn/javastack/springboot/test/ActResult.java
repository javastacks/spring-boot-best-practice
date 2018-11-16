package cn.javastack.springboot.test;

import lombok.Data;


@Data
public class ActResult {

    private int code = 0;
    private String msg;
    private Object data;

}