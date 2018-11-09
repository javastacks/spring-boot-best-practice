package cn.javastack.springboot.xml;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 微信公众号：Java技术栈
 */
@Data
@AllArgsConstructor
public class OrderInfo {

    private String orderNo;

    private long amount;

    private Date time;

}
