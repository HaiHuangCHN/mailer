package com.mailer.service;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mailer.DTO.Mail;
import com.mailer.DTO.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

	@Autowired
	private MailService mailService;

	@Test
	public void testSimpleMail() {
		Sender sender = new Sender(1L, "ihai", null, "Huang, Hai", null, false);
		Mail mail = new Mail(null, "Hello World", "This is a test email", null, sender);

		mailService.sendSimpleMail("h.a.huang@avanade.com", mail.getSubject(), mail.getText());
	}

	@Test
	public void testSendAttachmentsMail() throws MessagingException {
		Sender sender = new Sender(1L, "ihai", null, "Huang, Hai", null, false);
		Mail mail = new Mail(null, "Hello World", "This is a test email with attachment", null, sender);

		mailService.sendAttachmentsMail("h.a.huang@avanade.com", mail.getSubject(), mail.getText());
	}

	@Test
	public void testSendRichSpitterEmail() throws MessagingException {
		Sender sender = new Sender(1L, "ihai", null, "Huang, Hai", null, false);
		Mail mail = new Mail(null, "Hello World", "This is a test email with attachment", null, sender);

		mailService.sendRichSpitterEmail("h.a.huang@avanade.com", mail);
	}

}
