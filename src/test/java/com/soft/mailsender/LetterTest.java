package com.soft.mailsender;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import org.junit.Test;

public class LetterTest {

	
	@Test
	public void test() {

		HashMap<String, String> yesterdayPages = new HashMap<String, String>();
		HashMap<String, String> todayPages = new HashMap<String, String>();


		yesterdayPages.put("1-st url", "html 1");
		yesterdayPages.put("2-nd url", "html 2");
		yesterdayPages.put("3-d url", "html 3");
		yesterdayPages.put("4-th url", "html 4");
		yesterdayPages.put("5-th url", "html 5");
		yesterdayPages.put("6-th url", "html 6");

		todayPages.put("4-th url", "html 4");
		todayPages.put("5-th url", "altered html 5");
		todayPages.put("6-th url", "html 6");
		todayPages.put("7-th url", "html 7");
		todayPages.put("8-th url", "html 8");
		todayPages.put("9-th url", "html 9");
		
		MailConfiguration config = new MailProperties();
		config.load("./src/main/resources/mailconfig.xml");
		
		
		PageStorage pages = new PageStorage(yesterdayPages, todayPages);

		Letter letter = new Letter();
		System.out.println(letter.generateLetter(config, pages));

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("letter.html"), "utf-8"))) {
			writer.write(letter.generateLetter(config, pages));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Test is OK
	}

}
