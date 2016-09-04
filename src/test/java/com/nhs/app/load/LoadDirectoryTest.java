package com.nhs.app.load;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.document.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhs.app.NhsScraperAppConfig;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.exception.ScraperException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NhsScraperAppConfig.class })
public class LoadDirectoryTest implements ApplicationConstants {

	@Autowired
	private LoadDirectory loadDirectory;

	private List<String> pages;

	@Before
	public void setup() {

		InputStream in = getClass().getClassLoader().getResourceAsStream("inputfiles/pages_in_json.txt");
		pages = new ArrayList<>();
		pages.add(in.toString());

	}

	@Test
	public void loadDirectory() throws ScraperException {
		Assert.assertNotNull(loadDirectory);

		Document document = loadDirectory.load(pages);

		Assert.assertNotNull(document);
		Assert.assertNotNull(document.getField("pages"));

	}

	@Test(expected = NullPointerException.class)
	public void loadDirectoryWithNullPage() throws ScraperException {
		loadDirectory.load(null);

	}

	@Test
	public void loadDirectoryWithEmptyPage() throws ScraperException {

		Document document = loadDirectory.load(Arrays.asList(""));

		Assert.assertNotNull(document);
		Assert.assertNull(document.getField("pages"));

	}

}
