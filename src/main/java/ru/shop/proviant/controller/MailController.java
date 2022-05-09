package ru.shop.proviant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.shop.proviant.email.EmailData;

@Controller
public class MailController {

    public final JavaMailSender emailSender;

    @Autowired
    public MailController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    @ResponseBody
    @RequestMapping("/sendEmail")
    public String sendSimpleEmail() {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(EmailData.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("mess");

        this.emailSender.send(message);

        return "Email sent";
    }
}
