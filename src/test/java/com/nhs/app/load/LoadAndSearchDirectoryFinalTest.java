package com.nhs.app.load;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhs.app.NhsScraperAppConfig;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.domain.SearchResults;
import com.nhs.app.exception.ScraperException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NhsScraperAppConfig.class })
public class LoadAndSearchDirectoryFinalTest implements ApplicationConstants {

	@Autowired
	private LoadAndSearchDirectory loadAndSearchDirectoryFinal;

	private List<Page> pages;

	@Before
	public void setup() throws ScraperException {

		pages = new ArrayList<>();

		Page page1 = new Page();
		page1.setPageContent(
				"Chickenpox is a mild and common childhood illness that most children catch at some point.");
		page1.setTitle("Chickenpox");
		page1.setUrl("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");
		pages.add(page1);

		Assert.assertTrue(loadAndSearchDirectoryFinal.load(pages));

	}

	@Test
	public void searchForMild() throws ScraperException {

		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Chickenpox is a mild and common childhood illness that most children");

		Assert.assertNotNull(searchResults);
		Assert.assertNotNull(searchResults.getSearchText());
		assertThat(searchResults.getSearchText())
				.isEqualTo("Chickenpox is a mild and common childhood illness that most children");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");

	}

	@Test
	public void searchForFullTextChickenpox() throws ScraperException {

		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Chickenpox is a mild and common childhood illness that most children catch at some point.");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Chickenpox is a mild and common childhood illness that most children catch at some point.");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");

	}

	@Test(expected = NullPointerException.class)
	public void loadDirectoryWithNullPage() throws ScraperException {
		loadAndSearchDirectoryFinal.search(null);

	}

	

}
