package cn.javastack.springboot.web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

/**
 * 微信公众号：Java技术栈
 */
@Data
@JacksonXmlRootElement(localName = "response")
public class UserXml {

    @JacksonXmlProperty(localName = "user_id")
    private String id;

    @JacksonXmlProperty(localName = "user_name")
    private String name;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "order_info")
    private List<OrderInfo> orderList;

}