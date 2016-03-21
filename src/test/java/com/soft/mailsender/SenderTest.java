package com.soft.mailsender;

import org.junit.Test;

public class SenderTest {

	@Test
	public void test() {

		MailConfiguration config = new MailProperties();
		config.load("./src/main/resources/mailconfig.xml");
		
		Sender sender = new Sender();

		String message = "<html>" + "<head>" + "<meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>"
				+ "<title></title>" + "</head>" + "<body>" + "������������, ������� " + config.getSecretaryName()
				+ "!<br/>" + "<br/>" + "�� ��������� ����� �� ��������� ��� ������ ��������� ��������� ���������:<br/>"
				+ "1) ������� ��������� ��������:<br/>"; // +

		message += "<br/>" + "<i>� ���������,<i/><br/>" + "<br/>" + "<i>������������������ ������� �����������.<i/>"
				+ "</body>" + "</html>";

		try {
			sender.sendLetter(config, message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Test is OK

	}

}
