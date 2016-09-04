package com.nhs.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.SearchResults;
import com.nhs.app.exception.ScraperException;
import com.nhs.app.load.LoadAndSearchDirectory;

@Controller
public class SearchUiController implements ApplicationConstants {

	private static final Logger logger = LoggerFactory.getLogger(SearchUiController.class);

	@Autowired
	private LoadAndSearchDirectory loadAndSearchDirectoryFinal;

	@RequestMapping("/uihome")
	public String home(Model model) {
		SearchResults searchResults = new SearchResults();
		searchResults.setSearchText("");

		model.addAttribute("searchResults", searchResults);
		return "home";
	}

	@RequestMapping("/uisearch")
	public String search(final HttpServletRequest request, final HttpServletResponse response, Model model) {

		logger.info("Start - " + this.getClass().getSimpleName());

		logger.info("UI Search text ===>" + request.getParameter("searchText"));
		SearchResults searchResults = null;
		String returnString = null;
		try {
			searchResults = loadAndSearchDirectoryFinal.search(request.getParameter("searchText"));

			if (searchResults.isSuccess()) {
				returnString = searchResults.getRelevantMatchUrl();
			} else {
				returnString = searchResults.getMessage();
			}

		} catch (ScraperException e) {
			returnString = SERVICE_EXCEPTION + e.getMessage();
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		searchResults.setSearchText(request.getParameter("searchText"));

		model.addAttribute("searchResults", searchResults);

		logger.info("End - " + this.getClass().getSimpleName());

		return returnString;
	}
}
