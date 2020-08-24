package com.mailer.service;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mailer.DTO.Mail;
import com.mailer.DTO.Sender;

@Service
public class MqService {

    private static final Logger logger = LoggerFactory.getLogger(MqService.class);

    @Autowired
    private MailService mailService;

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(byte[] message) throws UnsupportedEncodingException {
        String msgStr = new String(message, "UTF-8");
        logger.info(" [x] Received '" + msgStr + "'");
        Sender sender = new Sender(1L, "ihai", null, "Huang, Hai", null, false);
        Mail mail = new Mail(null, "Hello World", "This is a test email", null, sender);

        mailService.sendSimpleMail("hai.huang.a@outlook.com", mail.getSubject(), mail.getText());
    }

}
