package com.nhs.app.load;

import static com.google.common.truth.Truth.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhs.app.NhsScraperAppConfig;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.exception.ScraperException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NhsScraperAppConfig.class })
public class ConvertToJsonTest implements ApplicationConstants {

	@Autowired
	private ConvertToJson convertToJson;

	private List<Page> pages;

	private ObjectMapper objectMapper;

	@Before
	public void setup() {
		pages = new ArrayList<>();

		Page page1 = new Page();
		page1.setPageContent("content 1");
		page1.setTitle("chickenpox");
		page1.setUrl("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");
		pages.add(page1);

		objectMapper = new ObjectMapper();
	}

	@Test
	public void LoadPagesDirect() throws ScraperException {
		Assert.assertNotNull(convertToJson);

		List<String> pagesJsonList = convertToJson.convert(pages);

		Assert.assertNotNull(pagesJsonList);
		Assert.assertEquals(pages.size(), pagesJsonList.size());

		assertThat(pagesJsonList).containsNoDuplicates();
		assertThat(pagesJsonList.contains(Arrays.asList("content 1")));
		assertThat(pagesJsonList.contains(Arrays.asList("chickenpox")));
		assertThat(pagesJsonList
				.contains(Arrays.asList("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx")));

	}

	@Test(expected = NullPointerException.class)
	public void convertNullPagesToJsonString() throws ScraperException {

		convertToJson.convert(null);
	}

	@Test
	public void convertEmptyPagesToJsonString()
			throws ScraperException, JsonParseException, JsonMappingException, IOException {

		List<String> pagesJsonList = convertToJson.convert(Arrays.asList(new Page()));

		Assert.assertNotNull(pagesJsonList);
		Assert.assertEquals(1, pagesJsonList.size());
		assertThat(pagesJsonList.get(0)).contains("url");
		assertThat(pagesJsonList.get(0)).contains("pageContent");
		assertThat(pagesJsonList.get(0)).contains("title");

		Page pageOutput = objectMapper.readValue(pagesJsonList.get(0), Page.class);

		Assert.assertNull(pageOutput.getPageContent());
		Assert.assertNull(pageOutput.getUrl());
		Assert.assertNull(pageOutput.getTitle());

	}

}
