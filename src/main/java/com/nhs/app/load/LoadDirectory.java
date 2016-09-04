package com.nhs.app.load;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.stereotype.Component;

import com.nhs.app.exception.ScraperException;

@Component
public class LoadDirectory {

	public Document load(List<String> pages) throws ScraperException {

		Objects.requireNonNull(pages, "Pages cannot be null");

		Analyzer analyzer = new StandardAnalyzer();

		// Store the index in memory:
		Directory directory = new RAMDirectory();
		Document doc = new Document();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter iwriter = null;
		try {
			iwriter = new IndexWriter(directory, config);

			// Loading the page json into document
			for (String pageText : pages) {

				// Load only if the page is not empty
				if (!pageText.isEmpty()) {
					doc.add(new Field("pages", pageText, TextField.TYPE_STORED));
				}

			}

			iwriter.addDocument(doc);
			iwriter.commit();
			iwriter.close();
		} catch (IOException ioe) {
			throw new ScraperException("Exception loading the pages into directory", ioe);
		} finally {

			try {
				if (iwriter != null) {
					iwriter.close();
				}

				if (directory != null) {
					//directory.close();
				}
			} catch (IOException e) {
				throw new ScraperException("Unable to close the index writer ", e);
			}

		}

		return doc;

	}

}
