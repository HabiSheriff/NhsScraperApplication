package com.nhs.app.scraper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.domain.PageDocument;
import com.nhs.app.exception.ScraperException;

@Component
public class ConditionPageScraper extends BaseScraper implements ApplicationConstants {

	public List<Page> getConditionsPages(String url, String cssQuery) throws ScraperException {

		List<Page> pages = null;

		PageDocument pageDocument = convertToPageDocument(url);

		Elements elements = pageDocument.getDocument().select(cssQuery);

		for (Element element : elements) {

			if (element.attr("href") != null) {

				if (pages == null) {
					pages = new ArrayList<>();
				}
				if (element.attr("href").contains(CONDITIONS_STRING)) {
					Page page = new Page();
					page.setUrl(element.attr("href"));
					page.setTitle(element.data());
					pages.add(page);

				}

			}

		}

		return pages;

	}
	
	

}
