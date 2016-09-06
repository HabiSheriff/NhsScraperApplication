package com.nhs.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nhs.app.load.ConvertToJson;
import com.nhs.app.load.LoadAndSearchDirectory;
import com.nhs.app.scraper.ConditionPageScraper;
import com.nhs.app.scraper.ConditionSubPageScraper;

@Configuration
public class NhsScraperAppConfig {

	@Bean
	public ConditionPageScraper conditionPageScraper() {
		return new ConditionPageScraper();
	}

	@Bean
	public ConditionSubPageScraper conditionSubPageScraper() {
		return new ConditionSubPageScraper();
	}

	@Bean
	public ConvertToJson convertToJson() {
		return new ConvertToJson();
	}

	@Bean
	public LoadAndSearchDirectory loadAndSearchDirectory() {
		return new LoadAndSearchDirectory();
	}


	@Bean
	public GetDataService getDataService() {
		return new GetDataService();
	}

}
