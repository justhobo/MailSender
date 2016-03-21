package com.soft.mailsender;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PageStorage {

	HashMap<String, String> yesterdayPages;
	HashMap<String, String> todayPages;

	public PageStorage(HashMap<String, String> yesterdayPages, HashMap<String, String> todayPages) {
		this.yesterdayPages = yesterdayPages;
		this.todayPages = todayPages;
	}

	public Set<String> getVanishedPages() {

		Set<String> urlsYesterday = yesterdayPages.keySet();
		Set<String> urlsToday = todayPages.keySet();

		Set<String> vanishedUrls = new HashSet<String>();

		for (String url : urlsYesterday)
			if (!urlsToday.contains(url))
				vanishedUrls.add(url);

		return vanishedUrls;
	}

	public Set<String> getNewPages() {

		Set<String> urlsYesterday = yesterdayPages.keySet();
		Set<String> urlsToday = todayPages.keySet();

		Set<String> newUrls = new HashSet<String>();

		for (String url : urlsToday)
			if (!urlsYesterday.contains(url))
				newUrls.add(url);

		return newUrls;
	}

	public Set<String> getAlteredPages() {

		Set<String> urlsYesterday = yesterdayPages.keySet();
		Set<String> urlsToday = todayPages.keySet();

		Set<String> actualUrls = new HashSet<String>(); // rename actualURLs

		for (String url : urlsToday)
			if (urlsYesterday.contains(url))
				actualUrls.add(url);

		Set<String> alteredUrls = new HashSet<String>();

		for (String url : actualUrls) {

			String htmlToday = todayPages.get(url);
			String htmlYesterday = yesterdayPages.get(url);

			if (!htmlToday.equals(htmlYesterday))
				alteredUrls.add(url);
		}

		return alteredUrls;
	}

}
