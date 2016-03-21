package com.soft.mailsender;

public class Letter {

	public String generateLetter(MailConfiguration config, PageStorage pages) {

		String message = "<html>" + 
				"<head>" + 
				"<meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>" +
				"<title></title>" + 
				"</head>" + 
				"<body>" + 
				"������������, ������� " + config.getSecretaryName() + "!<br/>" + 
				"<br/>" + 
				"�� ��������� ����� �� ��������� ��� ������ ��������� ��������� ���������:<br/>" +
				"1) ������� ��������� ��������:<br/>";

		for (String url : pages.getVanishedPages()) {
			message += "<a href=\"" + url + "\">" + url + "</a><br/>";
		}

		message += "2) ��������� ��������� ����� ��������<br/>";

		for (String url : pages.getNewPages()) {
			message += "<a href=\"" + url + "\">" + url + "</a><br/>";
		}

		message += "3) ���������� ��������� ��������<br/>";

		for (String url : pages.getAlteredPages()) {
			message += "<a href=\"" + url + "\">" + url + "</a><br/>";
		}
		message += "<br/>" + "<i>� ���������,<i/><br/>" + "<br/>" + "<i>������������������ ������� �����������.<i/>"
				+ "</body>" + "</html>";

		return message;
	}

}
