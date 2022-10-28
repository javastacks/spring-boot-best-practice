package cn.javastack.springboot.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EmailController {

    private final JavaMailSender javaMailSender;

    private final MailProperties mailProperties;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail(@RequestParam("email") String email,
                             @RequestParam("text") String text) {
        try {
            MimeMessage msg = createMimeMsg(email, text, "java.png");
            javaMailSender.send(msg);
        } catch (Exception ex) {
            log.error("邮件发送失败：", ex);
            return false;
        }
        return true;
    }

    /**
     * 创建复杂邮件
     * @param email
     * @param text
     * @param attachmentClassPath
     * @return
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private MimeMessage createMimeMsg(String email, String text, String attachmentClassPath) throws MessagingException, UnsupportedEncodingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true);
        mimeMessageHelper.setFrom(mailProperties.getFrom(), mailProperties.getPersonal());
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setBcc(mailProperties.getBcc());
        mimeMessageHelper.setSubject(mailProperties.getSubject());
        mimeMessageHelper.setText(text);
        mimeMessageHelper.addAttachment("附件",
                new ClassPathResource(attachmentClassPath));
        return msg;
    }

    /**
     * 创建简单邮件
     * @param email
     * @param text
     * @return
     */
    private SimpleMailMessage createSimpleMsg(String email, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailProperties.getFrom());
        msg.setTo(email);
        msg.setBcc(mailProperties.getBcc());
        msg.setSubject(mailProperties.getSubject());
        msg.setText(text);
        return msg;
    }

}
