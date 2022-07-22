package cn.javastack.springboot.web.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

/**
 * 微信公众号：Java技术栈
 */
@Data
public class User {

    @NonNull
    @JsonProperty("user-name")
    private String userName;

    private Long id;

    @NonNull
    private Integer age;

    @JsonIgnore
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memo;


}