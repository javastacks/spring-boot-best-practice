package cn.javastack.springboot.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 微信公众号：Java技术栈
 */
@Data
@AllArgsConstructor
public class User {

    private long id;

    private String name;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

}
