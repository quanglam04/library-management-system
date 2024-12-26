package com.vn.commonService.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration configuration;
    @Autowired
    private JavaMailSender javaMailSender;

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

    public void sendEmailWithTemplate(String to, String subject, String templateName, Map<String,Object> placeHolder,File file) {
    try{
        Template t = configuration.getTemplate(templateName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t,placeHolder);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(html, true);

        if(file != null){
            FileSystemResource resource = new FileSystemResource(file);
            helper.addAttachment(resource.getFilename(), resource);
        }
        javaMailSender.send(mimeMessage);
        System.out.println("Email send with template success ");
    }catch(MessagingException | IOException | TemplateException e){
        System.out.println(e.getMessage());
    }

    }
}
