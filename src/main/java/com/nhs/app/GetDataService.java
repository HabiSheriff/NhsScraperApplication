package com.nhs.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.exception.ScraperException;
import com.nhs.app.load.LoadAndSearchDirectory;
import com.nhs.app.scraper.ConditionPageScraper;

@Component
public class GetDataService implements ApplicationConstants {
	
	private static final Logger logger = LoggerFactory.getLogger(GetDataService.class);

	@Autowired
	ConditionPageScraper conditionPageScraper;

	@Autowired
	LoadAndSearchDirectory loadAndSearchDirectory;

	public Boolean getData() throws ScraperException {
		
		logger.info(this.getClass().getSimpleName() + " - Get the data from web pages");

		return loadAndSearchDirectory
				.load(conditionPageScraper.getConditionsPages(MAIN_NHS_PAGE, CONDITIONS_LI_CSS_STRING));

	}

}
