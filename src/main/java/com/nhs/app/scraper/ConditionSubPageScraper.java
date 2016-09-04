package com.nhs.app.scraper;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.domain.PageDocument;
import com.nhs.app.exception.ScraperException;

@Component
public class ConditionSubPageScraper extends BaseScraper implements ApplicationConstants {

	public Page getConditionsSubPagesContent(String url, String cssQuery) throws ScraperException {

		Page page = new Page();
		StringBuffer paragraphText = new StringBuffer();

		PageDocument pageDocument = convertToPageDocument(url);

		Elements elements = pageDocument.getDocument().select(cssQuery);

		Elements titleElement = pageDocument.getDocument().select(TITLE_CSS_STRING);

		page.setUrl(url);
		page.setTitle(titleElement.text());
		for (Element element : elements) {

			if (element.attr("p") != null) {

				paragraphText.append(element.text());

			}

		}

		page.setPageContent(paragraphText.toString());

		return page;

	}

}
