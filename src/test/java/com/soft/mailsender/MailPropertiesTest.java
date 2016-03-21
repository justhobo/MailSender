package com.soft.mailsender;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

public class MailPropertiesTest {

	@Test
	public void test() {

		Properties properties = new Properties();
		
		properties.setProperty("secretaryName", "Алла Борисовна");
		properties.setProperty("password", "password here");
		properties.setProperty("login", "ust.valeri@gmail.com");
		properties.setProperty("mailFrom", "ust.valeri@gmail.com");
		properties.setProperty("mailTo", "ust.valeri@gmail.com");
		properties.setProperty("letterSubject", "This Letter is for you! Это письмо для Вас!");
		properties.setProperty("mail.smtps.host", "smtp.gmail.com");
		properties.setProperty("mail.smtps.auth", "true");
		properties.setProperty("Content-type", "text/html; charset=utf-8");
		
		MailConfiguration mailConfig = new MailProperties(properties);
		
		mailConfig.store("./src/main/resources/mailconfig.xml");
		
		MailConfiguration mailConfigLoaded = new MailProperties();
		mailConfigLoaded.load("./src/main/resources/mailconfig.xml");
		
		String expectedLogin = "ust.valeri@gmail.com";
		String actualLogin = mailConfig.getLogin();
		assertEquals(expectedLogin, actualLogin);

		String expectedSecretaryName = "Алла Борисовна";
		String actualSecretaryName = mailConfig.getSecretaryName();
		assertEquals(expectedSecretaryName, actualSecretaryName);

		String expectedPassword = "qweras432";
		String actualPassword = mailConfig.getPassword();
		assertEquals(expectedPassword, actualPassword);

		String expectedMailFrom = "ust.valeri@gmail.com";
		String actualMailFrom = mailConfig.getMailFrom();
		assertEquals(expectedMailFrom, actualMailFrom);

		String expectedLetterSubject = "This Letter is for you! Это письмо для Вас!";
		String actualLetterSubject = mailConfig.getMailSubject();
		assertEquals(expectedLetterSubject, actualLetterSubject);
		
		String expectedMailSmtpsHost = "smtp.gmail.com";
		String actualMailSmtpsHost = mailConfig.getMailSmtpsHost();
		assertEquals(expectedMailSmtpsHost, actualMailSmtpsHost);
		
		String expectedMailSmtpsAuth = "true";
		String actualMailSmtpsAuth = mailConfig.getMailSmtpsAuth();
		assertEquals(expectedMailSmtpsAuth, actualMailSmtpsAuth);
		
	}

}
