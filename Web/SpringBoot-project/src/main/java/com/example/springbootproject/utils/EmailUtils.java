package com.example.springbootproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtils {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailUtils(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送简单邮件
     *
     * @param to      收件人邮箱地址
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sender@example.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }

    /**
     * 发送带附件的邮件
     *
     * @param to       收件人邮箱地址
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param filePath 附件文件路径
     * @throws MessagingException
     */
    public void sendMailWithAttachment(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("sender@example.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        helper.addAttachment(file.getFilename(), file);

        javaMailSender.send(message);
    }
}
