package com.soft.mailsender;

public class Letter {

	public String generateLetter(MailConfiguration config, PageStorage pages) {

		String message = "<html>" + 
				"<head>" + 
				"<meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>" +
				"<title></title>" + 
				"</head>" + 
				"<body>" + 
				"Здравствуйте, дорогая " + config.getSecretaryName() + "!<br/>" + 
				"<br/>" + 
				"За последние сутки во вверенных Вам сайтах произошли следующие изменения:<br/>" +
				"1) Исчезли следующие страницы:<br/>";

		for (String url : pages.getVanishedPages()) {
			message += "<a href=\"" + url + "\">" + url + "</a><br/>";
		}

		message += "2) Появились следующие новые страницы<br/>";

		for (String url : pages.getNewPages()) {
			message += "<a href=\"" + url + "\">" + url + "</a><br/>";
		}

		message += "3) Изменились следующие страницы<br/>";

		for (String url : pages.getAlteredPages()) {
			message += "<a href=\"" + url + "\">" + url + "</a><br/>";
		}
		message += "<br/>" + "<i>С уважением,<i/><br/>" + "<br/>" + "<i>автоматизированная система мониторинга.<i/>"
				+ "</body>" + "</html>";

		return message;
	}

}
