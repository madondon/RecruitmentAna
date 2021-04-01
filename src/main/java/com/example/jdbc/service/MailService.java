package com.example.jdbc.service;

public interface MailService {

    void sendAttachmentsMail(String to,String subject,String content,String filePath);

}