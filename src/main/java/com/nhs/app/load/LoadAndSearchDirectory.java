package com.nhs.app.load;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.domain.SearchResults;
import com.nhs.app.exception.ScraperException;

@Component
public class LoadAndSearchDirectory implements ApplicationConstants {

	private static final Logger logger = LoggerFactory.getLogger(LoadAndSearchDirectory.class);

	@Autowired
	ConvertToJson convertToJson;

	private Directory directory = new RAMDirectory();

	public Boolean load(List<Page> pages) throws ScraperException {

		logger.info("Load index ...");

		Objects.requireNonNull(pages, "Page object cannot be null");

		IndexWriter indexWriter = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
			iwc.setOpenMode(OpenMode.CREATE);
			indexWriter = new IndexWriter(directory, iwc);

			List<String> pageJson = convertToJson.convert(pages);

			Map<String, String> pageMap = new HashMap<>();

			// add documents
			for (String pageJsonString : pageJson) {
				Document doc = new Document();

				pageMap = objectMapper.readValue(pageJsonString, new TypeReference<Map<String, String>>() {
				});

				for (Map.Entry<String, String> pageMapEntry : pageMap.entrySet()) {

					doc.add(new TextField(pageMapEntry.getKey(), pageMapEntry.getValue(), Field.Store.YES));
				}

				indexWriter.addDocument(doc);
			}
			indexWriter.commit();
			logger.info("Index has been loaded successfully");
		} catch (IOException ex) {
			throw new ScraperException("Error loading the directory or index : " + ex);
		} finally {
			try {
				indexWriter.close();
			} catch (IOException e) {
				throw new ScraperException("Exception while closing the index writer: " + e);
			}
		}

		return true;
	}

	public SearchResults search(String searchText) throws ScraperException {

		logger.info("Search the text in index :" + searchText);

		Objects.requireNonNull(searchText, "Search text cannot be null");

		SearchResults searchResults = null;
		try {

			searchResults = new SearchResults();
			searchResults.setSuccess(false);

			if (searchText.trim().equals("")) {

				searchResults.setMessage(SEARCH_TEXT_IS_EMPTY);
				return searchResults;
			}

			searchResults.setSearchText(searchText);

			IndexReader indexReader = DirectoryReader.open(directory);
			int numDocs = indexReader.numDocs();

			logger.info("Number of documents in index :" + numDocs);

			IndexSearcher indexSearcher = new IndexSearcher(indexReader);
			// Term term = new Term("pageContent", searchText);
			// Query query = new TermQuery(term);

			QueryParser queryParser = new QueryParser("pageContent", new StandardAnalyzer());
			queryParser.setAllowLeadingWildcard(true);
			Query query = queryParser.parse("*" + searchText + "*");

			// TermRangeQuery termRangeQuery = new TermRangeQuery("pageContent",
			// new BytesRef(searchText),
			// new BytesRef(searchText), true, false);
			// TopDocs topDocs = indexSearcher.search(query, 1, Sort.RELEVANCE);
			// TopDocs topDocs = indexSearcher.search(termRangeQuery, 1,
			// Sort.RELEVANCE);
			TopDocs topDocs = indexSearcher.search(query, 1, Sort.RELEVANCE);

			ScoreDoc[] hits = topDocs.scoreDocs;

			if (hits.length >= 1) {
				Document hitDoc = indexSearcher.doc(hits[0].doc);
				String relevantUrl = hitDoc.get("url");
				if (relevantUrl != null) {
					searchResults.setRelevantMatchUrl(relevantUrl);
					searchResults.setSuccess(true);
					logger.info("Found the relevant match for search text :" + relevantUrl);
				} else {
					searchResults.setMessage(RELEVANT_MATCH_NOT_FOUND);
					logger.info("Relevant url not present though document hit is present ");
					logger.info("Relevant match not found for search text :" + searchText);
				}

				searchResults.setScore(hits[0].score);

			} else {
				searchResults.setMessage(RELEVANT_MATCH_NOT_FOUND);
				logger.info("No document hit found in index search");
				logger.info("Relevant match not found for search text :" + searchText);

			}

		} catch (IOException e) {
			throw new ScraperException("Exception while trying to search the dicectory", e);
		} catch (ParseException e) {
			throw new ScraperException("Exception while trying to search the dicectory", e);
		}
		return searchResults;
	}

}
