package cn.javastack.springboot.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 微信公众号：Java技术栈
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(indexName = "javastack")
public class User {

    private long id;

    private String name;

    private int sex;

}
