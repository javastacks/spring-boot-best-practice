package cn.javastack.springboot.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

    /**
     * 发件人
     */
    private String from;

    /**
     * 发件人昵称
     */
    private String personal;

    /**
     * 抄送人
     */
    private String bcc;

    /**
     * 主题
     */
    private String subject;

}
