package cn.javastack.springboot.redis.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 微信公众号：Java技术栈
 */
@Data
public class User {

    private int id;

    private String name;

    private Date birthday;

    private List<String> interesting;

    private Map<String, Object> others;

}
