package com.mailer.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mailer.DTO.Mail;

@Service
public class MailServiceImpl implements MailService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("mailSender")
	private JavaMailSender mailSender;

	@Value("${mail.fromMail.addr}")
	private String from;

	@Override
	public void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);

		try {
			mailSender.send(message);
			logger.info("Simple email has been sent!");
		} catch (Exception e) {
			logger.info("Send email with exception: ", e);
		}

	}

	@Override
	public void sendHtmlMail(String to, String subject, String content) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendAttachmentsMail(String to, String subject, String content) throws MessagingException {
		// by calling mailSender.createMimeMessage can create a MIME message
		MimeMessage message = mailSender.createMimeMessage();
		// the second argument is TRUE, means that the message is MULTIPART message that
		// is able to be attached
		// The third argument(UTF-8) to avoid Chinese display problem
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(content);
		// Fetch attachment from classpath
		ClassPathResource couponImage = new ClassPathResource("/attachments/Smile.png");
		// The first argument is the name of the attachment, which will be displayed in
		// the email attachment
		// Resource
		helper.addAttachment("Smile.png", couponImage);
		try {
			mailSender.send(message);
			logger.info("Email with attachment has been sent!");
		} catch (Exception e) {
			logger.info("Send email with exception: ", e);
		}
	}

	@Override
	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
		// TODO Auto-generated method stub

	}

	/**
	 * Create an email with embedded image
	 */
	@Override
	public void sendRichSpitterEmail(String to, Mail mail) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		// The second argument means the first argument is HTML
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject("New email from " + mail.getSender().getName());
		// cid：spitterLogo: flag a argument and will be embed an image for this argument
		// The second argument means the first argument is HTML
		helper.setText("<html><body><img src='cid:embeddedLogo'>" + "<h4>" + mail.getSender().getName() + "says...</h4>"
				+ "<i>" + mail.getText() + "</i>" + "</body></html>", true);
		//
		ClassPathResource image = new ClassPathResource("/attachments/Smile.png");
		// Embed an image for the variable
		helper.addInline("embeddedLogo", image);
		try {
			mailSender.send(message);
			logger.info("Email with embedded image has been sent!");
		} catch (Exception e) {
			logger.info("Send email with exception: ", e);
		}
	}

}
