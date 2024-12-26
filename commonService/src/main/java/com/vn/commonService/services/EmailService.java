package com.vn.commonService.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleMail(String to, String subject, String content, boolean html, File file) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            // Add attachment if provided
            if(file != null){
                FileSystemResource resource = new FileSystemResource(file);
                helper.addAttachment(resource.getFilename(), resource);
            }

            mailSender.send(mimeMessage);
            System.out.println("Email send success");
        }
        catch (MessagingException ex){
            System.out.println(ex.getMessage());
        }
    }
}
