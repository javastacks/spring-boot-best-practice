package cn.javastack.springboot.ds.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
public class UserDO {

    private long id;

    private String username;

    private String phone;

    @Column(value = "create_time")
    private LocalDateTime createTime;

    private int status;

}
