package cn.javastack.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信公众号：Java技术栈
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("admin@javastack.cn");
        msg.setBcc();
        msg.setTo("admin@javastack.cn");
        msg.setSubject("Java技术栈投稿");
        msg.setText("技术分享");
        try {
            javaMailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }


}
