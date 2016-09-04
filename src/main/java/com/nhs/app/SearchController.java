package com.nhs.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.SearchResults;
import com.nhs.app.load.LoadAndSearchDirectory;

@RestController
public class SearchController implements ApplicationConstants {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private LoadAndSearchDirectory loadAndSearchDirectoryFinal;

	@RequestMapping("/")
	public String home() {

		return "Service is up!!!";
	}

	@RequestMapping("/search/{searchtext}")
	public String search(@PathVariable("searchtext") String searchText) {

		logger.info("Start - " + this.getClass().getSimpleName());

		logger.info("Search text ===>" + searchText);
		String returnString = null;
		SearchResults searchResults = null;
		searchResults = loadAndSearchDirectoryFinal.search(searchText);

		if (searchResults.isSuccess()) {

			returnString = searchResults.getRelevantMatchUrl();
		} else {
			returnString = searchResults.getMessage();
		}

		logger.info("Search results =============>" + searchResults.toString());
		logger.info("Search service response string =============>" + returnString);
		logger.info("End - " + this.getClass().getSimpleName());
		return returnString;
	}
}
