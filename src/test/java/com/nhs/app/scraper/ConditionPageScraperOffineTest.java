package com.nhs.app.scraper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhs.app.NhsScraperAppConfig;
import com.nhs.app.constants.ApplicationConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NhsScraperAppConfig.class })
public class ConditionPageScraperOffineTest implements ApplicationConstants {

	@Autowired
	private ConditionPageScraper conditionPageScraper;

	

}
