package com.nhs.app.scraper;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhs.app.NhsScraperAppConfig;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.exception.ScraperException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NhsScraperAppConfig.class })
public class ConditionPageScraperTest implements ApplicationConstants {

	@Autowired
	private ConditionPageScraper conditionPageScraper;

	@Test
	public void getConditionsPages() throws ScraperException {
		Assert.assertNotNull(conditionPageScraper);
		List<Page> pages = conditionPageScraper.getConditionsPages(MAIN_NHS_PAGE, CONDITIONS_LI_CSS_STRING);

		Assert.assertNotNull(pages);
		Assert.assertEquals(22, pages.size());
		
		assertThat(pages).containsNoDuplicates();
		assertThat(pages.stream().map(Page::getUrl).collect(Collectors.toList()).contains(
				Arrays.asList("/conditions/chickenpox", "/conditions/Thrush/Pages/Introduction.aspx", "/conditions/depression/Pages/Introduction.aspx",
						"/conditions/sciatica", "/conditions/norovirus", "/conditions/Diabetes-type2/Pages/Introduction.aspx")));
		
	}

}
