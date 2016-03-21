package com.soft.mailsender;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

public class PageStorageTest {

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

		PageStorage p = new PageStorage(yesterdayPages, todayPages);
		Set<String> vanishedUrls = p.getVanishedPages();
		Set<String> newUrls = p.getNewPages();
		Set<String> alteredUrls = p.getAlteredPages();

		System.out.printf("Vanished: %s\n", vanishedUrls);
		System.out.printf("New: %s\n", newUrls);
		System.out.printf("Altered: %s\n", alteredUrls);

		
		// Test is OK
	}

}
