package com.skillswap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

@Autowired
private JavaMailSender mailSender;

public void sendEmail(String toEmail,String fromName,String fromEmail){

SimpleMailMessage message = new SimpleMailMessage();

message.setTo(toEmail);
message.setSubject("New SkillSwap Connection Request");

message.setText(
fromName + " wants to connect with you on SkillSwap.\n\n" +
"User Email: " + fromEmail + "\n" +
"Connect and start learning together!"
);

mailSender.send(message);
}
}