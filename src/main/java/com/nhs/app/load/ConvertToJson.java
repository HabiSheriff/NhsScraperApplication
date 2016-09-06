package com.nhs.app.load;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhs.app.domain.Page;
import com.nhs.app.exception.ScraperException;

/**
 * 
 * Convert the page object to JSON string
 * 
 * @author
 *
 */

@Component
public class ConvertToJson {

	/**
	 * convert {@link List<Page> pages} - Converts list of pages into a Json string.
	 * 
	 * @param List<Page> pages - takes inputs as list of pages
	 *            
	 * @return List<String> - returns as list of strings 
	 */
	public List<String> convert(List<Page> pages) throws ScraperException {

		Objects.requireNonNull(pages, "Pages object cannot be null");

		ObjectMapper objectMapper = new ObjectMapper();

		List<String> pagesJsonList = new ArrayList<>();

		try {
			for (Page page : pages) {
				pagesJsonList.add(objectMapper.writeValueAsString(page));
			}
		} catch (JsonProcessingException je) {
			throw new ScraperException("Page object cannot be converted to JSON string ", je);
		}

		return pagesJsonList;
	}

}
