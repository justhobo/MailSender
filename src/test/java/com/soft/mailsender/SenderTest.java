package com.soft.mailsender;

import org.junit.Test;

public class SenderTest {

	@Test
	public void test() {

		MailConfiguration config = new MailProperties();
		config.load("./src/main/resources/mailconfig.xml");
		
		Sender sender = new Sender();

		String message = "<html>" + "<head>" + "<meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>"
				+ "<title></title>" + "</head>" + "<body>" + "Здравствуйте, дорогая " + config.getSecretaryName()
				+ "!<br/>" + "<br/>" + "За последние сутки во вверенных Вам сайтах произошли следующие изменения:<br/>"
				+ "1) Исчезли следующие страницы:<br/>"; // +

		message += "<br/>" + "<i>С уважением,<i/><br/>" + "<br/>" + "<i>автоматизированная система мониторинга.<i/>"
				+ "</body>" + "</html>";

		try {
			sender.sendLetter(config, message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Test is OK

	}

}
