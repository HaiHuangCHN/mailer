package com.mailer.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:mail.properties")
public class MailerConfig {

    @Bean(name = "mailSender")
    public JavaMailSenderImpl mailSender(Environment env) {
        // JavaMailSenderImpl is a class that has been implemented by Spring.io, we can
        // use it directly instead of spending effort to create one
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // hostname of the mail server
        mailSender.setHost(env.getProperty("spring.mail.host"));
        // port that the server scans
        mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        // note: this is not the password of the email account, it is authorization code
        mailSender.setPassword(env.getProperty("spring.mail.password"));
        // encode with SSL, it is required, nor that can not run application as normal
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }
}
