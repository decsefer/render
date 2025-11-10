package com.ipn.mx.administracioneventos.util.service.Impl;

import com.ipn.mx.administracioneventos.util.service.EmailService;
import jakarta.annotation.Resource;
import jakarta.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;


    Resource resourceFile;
    @Override
    public void sendEmail(String to, String subject, String text) {
        MimeMailMessage message = mailSender.createMimeMessage();
        MimeMailMessage messageHelper;
        try{
            messageHelper= new MimeMessageHelper(message,true,"UTF-8");
            messageHelper.setFrom(new InternetAddress("noreply@gmail.com","Administacion de eventos"));
            messageHelper.addAtachment("archivo",new File(resourceFile.getFile().toURI));
            messageHelper.setText(text);
            mailSender.send(message);

        }catch (Exception e){}
        throw new RuntimeException(e);
    }



}
