package com.ApiJava.Biblioteca_JAVA_API.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("spring.mail.username")
    private String email;

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(String para, String assunto, String texto){
        System.out.println(email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setTo(para);
        message.setSubject(assunto);
        message.setText(texto);
        javaMailSender.send(message);

        System.out.println("email enviado|");

    }
}
