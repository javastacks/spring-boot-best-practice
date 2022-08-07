package cn.javastack.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@TableName("t_user")
@Data
public class UserDO implements Serializable {

    @TableField()
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private String username;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private String phone;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL, fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(insertStrategy = FieldStrategy.NOT_NULL)
    private Integer status;

}