package com.soft.mailsender;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class Sender {

	public void sendLetter(MailConfiguration config, String message) throws Exception {

		String MAIL_DESTINATION = config.getMailTo();
		String PASSWORD = config.getPassword();
		String LOGIN = config.getLogin();
		String MAIL_FROM = config.getMailFrom();
		String LETTER_SUBJECT = config.getMailSubject();
		String CONTENT_TYPE = config.getContentType();
		String MAIL_SMTPS_HOST = config.getMailSmtpsHost();
		String MAIL_SMTPS_AUTH = config.getMailSmtpsAuth();
		
		Properties props = System.getProperties();
		props.put("mail.smtps.host", MAIL_SMTPS_HOST);
		props.put("mail.smtps.auth", MAIL_SMTPS_AUTH);

		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(MAIL_FROM));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MAIL_DESTINATION, false));
		msg.setSubject(LETTER_SUBJECT);
		msg.setContent(message, CONTENT_TYPE);
		msg.setSentDate(new Date());

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect(MAIL_SMTPS_HOST, LOGIN, PASSWORD);
		t.sendMessage(msg, msg.getAllRecipients());

		System.out.println("Response: " + t.getLastServerResponse());
		t.close();
	}

}
