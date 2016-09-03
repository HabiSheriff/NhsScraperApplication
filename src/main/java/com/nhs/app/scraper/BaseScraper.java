package com.nhs.app.scraper;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.nhs.app.domain.PageDocument;
import com.nhs.app.exception.ScraperException;

public class BaseScraper {

	public PageDocument convertToPageDocument(String url) throws ScraperException {

		PageDocument pageDocument = null;
		try {
			URLConnection connection = new URL(url).openConnection();
			Document doc = Jsoup.parse(connection.getInputStream(), "UTF-8", "http://baseUrl/");
			pageDocument = new PageDocument(doc, connection.getContentLength());

		} catch (IOException e) {
			throw new ScraperException("Error scraping url : " + url, e);
		}
		return pageDocument;

	}
	
	public String getElementValueAsString(Document document, String cssQuery) throws ScraperException {

		Elements elements = document.select(cssQuery);
		if (elements.isEmpty()) {
			throw new ScraperException("Unable to get element for '" + cssQuery + "'");
		}
		return elements.get(0).ownText();

	}

}
