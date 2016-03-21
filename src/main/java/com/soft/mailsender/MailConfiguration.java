package com.soft.mailsender;

public interface MailConfiguration {

	public void store(String file);
	
	public void load(String file); 
	
	public String getLogin();

	public String getPassword();

	public String getSecretaryName();

	public String getMailTo();

	public String getMailFrom();

	public String getMailSubject();

	public String getMailSmtpsHost();

	public String getMailSmtpsAuth();

	public String getContentType();

}
