package com.soft.mailsender;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class MailProperties implements MailConfiguration {

	private static final Logger logger = Logger.getLogger(MailProperties.class);

	private Properties prop;

	public MailProperties() {
		this.prop = new Properties();
	}

	public MailProperties(Properties properties) {
		this.prop = properties;

	}

	public void store(String file) {

		Properties prop = this.prop;
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(file);
			prop.storeToXML(outputStream, null);
		} catch (IOException io) {
			logger.error(io, io);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.error(e, e);
				}
			}
		}
	}

	public void load(String file) {

		this.prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(file);
			prop.loadFromXML(input);
		} catch (IOException ex) {
			logger.error(ex, ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e, e);
				}
			}
		}
	}

	
	public String getLogin() {

		String login = prop.getProperty("login");
		return login;
	}

	public String getPassword() {

		String password = prop.getProperty("password");
		return password;
	}

	public String getSecretaryName() {

		String secretaryName = prop.getProperty("secretaryName");
		return secretaryName;
	}

	public String getMailTo() {

		String mailTo = prop.getProperty("mailTo");
		return mailTo;
	}

	public String getMailFrom() {

		String mailFrom = prop.getProperty("mailFrom");
		return mailFrom;
	}

	public String getMailSubject() {

		String letterSubject = prop.getProperty("letterSubject");
		return letterSubject;
	}

	public String getMailSmtpsHost() {

		String mailSmtpsHost = prop.getProperty("mail.smtps.host");
		return mailSmtpsHost;
	}

	public String getMailSmtpsAuth() {
		String mailSmtpsAuth = prop.getProperty("mail.smtps.auth");
		return mailSmtpsAuth;
	}

	public String getContentType() {
		String contentType = prop.getProperty("Content-type");
		return contentType;
	}

}
