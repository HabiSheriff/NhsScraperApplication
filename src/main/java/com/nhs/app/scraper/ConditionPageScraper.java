package com.nhs.app.scraper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.domain.PageDocument;
import com.nhs.app.exception.ScraperException;

@Component
public class ConditionPageScraper extends BaseScraper implements ApplicationConstants {

	@Autowired
	private ConditionSubPageScraper conditionSubPageScraper;

	public List<Page> getConditionsPages(String url, String cssQuery) throws ScraperException {

		List<Page> pages = null;

		PageDocument pageDocument = convertToPageDocument(url);

		Elements elements = pageDocument.getDocument().select(cssQuery);

		for (Element element : elements) {

			if (element.attr("href") != null) {
				String subPageUrl = element.attr("href");

				if (pages == null) {
					pages = new ArrayList<>();
				}
				if (subPageUrl.contains(CONDITIONS_STRING)) {
					pages.add(conditionSubPageScraper.getConditionsSubPagesContent(getScrapeSubPageUrl(subPageUrl),
							CONDITIONS_SUB_PAGE_CSS_STRING));

				}

			}

		}

		return pages;

	}

	private String getScrapeSubPageUrl(String inputUrl) {

		Objects.requireNonNull(inputUrl, "Sub page url cannot be null");

		StringBuffer sb = new StringBuffer();

		if (!inputUrl.contains(NHS_HOME_URL)) {
			sb.append(NHS_HOME_URL);
			sb.append(inputUrl);
		} else {
			sb.append(inputUrl);
		}

		if (!inputUrl.contains(NHS_INTRODUCTION_URL)) {
			sb.append(NHS_INTRODUCTION_URL);
		}

		return sb.toString();

	}

}
