package com.example.jdbc.service.impl;

import com.example.jdbc.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;


@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送带附件的邮件
     * @param to 接受者
     * @param subject 主题
     * @param content 内容
     * @param filePath 文件路径
     */
    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom("a1224641706@163.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            FileSystemResource file=new FileSystemResource(new File(filePath));
            String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
//      //添加多个附件可以使用多条
//      //helper.addAttachment(fileName,file);
            helper.addAttachment(fileName,file);
            mailSender.send(message);
            System.out.println("带附件的邮件发送成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送带附件的邮件失败");
        }
    }


}