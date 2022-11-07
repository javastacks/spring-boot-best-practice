package cn.javastack.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 微信公众号：Java技术栈
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "javastack")
public class User {

    private long id;

    private String name;

    private int sex;

}
