package com.soft.mailsender;

import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

public class App {
	
	private static final Logger logger = Logger.getLogger(App.class);
	
	public static void main(String[] args) {

		HashMap<String, String> yesterdayPages = new HashMap<String, String>();
		HashMap<String, String> todayPages = new HashMap<String, String>();

		
		yesterdayPages.put("https://example.com/1", "html 1");
		yesterdayPages.put("https://example.com/2", "html 2");
		yesterdayPages.put("https://example.com/3", "html 3");
		yesterdayPages.put("https://example.com/4", "html 4");
		yesterdayPages.put("https://example.com/5", "html 5");
		yesterdayPages.put("https://example.com/6", "html 6");

		todayPages.put("https://example.com/4", "html 4");
		todayPages.put("https://example.com/5", "altered html 5");
		todayPages.put("https://example.com/6", "html 6");
		todayPages.put("https://example.com/7", "html 7");
		todayPages.put("https://example.com/8", "html 8");
		todayPages.put("https://example.com/9", "html 9");

		
		Properties properties = new Properties();

		properties.setProperty("secretaryName", "Алла Борисовна");
		properties.setProperty("password", "password here");
		properties.setProperty("login", "ex@example.com");
		properties.setProperty("mailFrom", "ex@example.com");
		properties.setProperty("mailTo", "ex@example.com");
		properties.setProperty("letterSubject", "This Letter is for you! Это письмо для Вас!");
		properties.setProperty("mail.smtps.host", "smtp.gmail.com");
		properties.setProperty("mail.smtps.auth", "true");
		properties.setProperty("Content-type", "text/html; charset=utf-8");
		
		MailConfiguration mailConfig = new MailProperties(properties);
		mailConfig.store("./src/main/resources/mailconfig.xml");
		
		/*
		MailConfiguration mailConfigLoaded = new MailProperties();
		mailConfigLoaded.load("./src/main/resources/mailconfig.xml");
		*/
		
		
		PageStorage pages = new PageStorage(yesterdayPages, todayPages);
		Letter letter = new Letter();
		String message = letter.generateLetter(mailConfig, pages);

		Sender sender = new Sender();
		try {
			sender.sendLetter(mailConfig, message);
		} catch (Exception e) {
			logger.error(e, e);
		}

	}

}
