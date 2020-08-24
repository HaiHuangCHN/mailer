package com.mailer.service;

import javax.mail.MessagingException;

import com.mailer.DTO.Mail;

public interface MailService {

	public void sendSimpleMail(String to, String subject, String content);

	public void sendHtmlMail(String to, String subject, String content);

	public void sendAttachmentsMail(String to, String subject, String content) throws MessagingException;

	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);

	public void sendRichSpitterEmail(String to, Mail mail) throws MessagingException;

}
