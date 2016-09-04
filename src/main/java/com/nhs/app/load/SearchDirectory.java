package com.nhs.app.load;

import java.io.IOException;
import java.util.Objects;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.domain.SearchResults;
import com.nhs.app.exception.ScraperException;

@Component
public class SearchDirectory implements ApplicationConstants {

	public SearchResults search(Document document, String searchText) throws ScraperException {

		Objects.requireNonNull(searchText, "Search text cannot be null");
		Objects.requireNonNull(document, "In memory document cannot be null. Please check the load directory");
		
		SearchResults searchResults = new SearchResults();
		searchResults.setSuccess(false);
		
		if (searchText.trim().equals("")) {
			
			searchResults.setMessage(SEARCH_TEXT_IS_EMPTY);
			return searchResults;
		}

	
		IndexSearcher isearcher = null;
		Directory directory = null;
		DirectoryReader ireader = null;

		searchResults.setSearchText(searchText);

		try {
			Analyzer analyzer = new StandardAnalyzer();

			directory = new RAMDirectory();

			ireader = DirectoryReader.open(directory);
			isearcher = new IndexSearcher(ireader);

			QueryParser parser = new QueryParser("pages", analyzer);
			Query query = parser.parse(searchText);
			ScoreDoc[] hits = isearcher.search(query, 1, Sort.RELEVANCE).scoreDocs;

			// Iterate through the results:
			for (int i = 0; i < hits.length; i++) {
				Document hitDoc = isearcher.doc(hits[i].doc);
				String relevantUrl = getRelevantMatchedUrl(hitDoc.get("pages"));
				if(relevantUrl != null)
				{
					searchResults.setRelevantMatchUrl(relevantUrl);
					searchResults.setSuccess(true);
				}
				else
				{
					searchResults.setMessage(RELEVANT_MATCH_NOT_FOUND);
				}

				searchResults.setScore(hits[i].score);

			}
		} catch (IOException | ParseException e) {
			throw new ScraperException("Exception while trying to search the dicectory", e);
		} finally {
			try {
				if (directory != null) {
					directory.close();
				}
				if (ireader != null) {
					ireader.close();
				}
			} catch (IOException e) {
				throw new ScraperException("Exception while closing the directory or ireader objects", e);
			}

		}

		return searchResults;
	}

	/**
	 *
	 * Extract the relevant URL from the page json.
	 * 
	 * @param pageJson
	 * @return
	 */
	private String getRelevantMatchedUrl(String pageJson) {

		String relevantUrl = null;

		if (pageJson != null && !pageJson.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();

			try {
				Page page = objectMapper.readValue(pageJson, Page.class);
				if (page != null) {
					relevantUrl = page.getUrl();
				}

			} catch (IOException e) {

			}

		}

		return relevantUrl;

	}

}
