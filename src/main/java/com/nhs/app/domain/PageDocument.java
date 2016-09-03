package com.nhs.app.domain;

import org.jsoup.nodes.Document;

public class PageDocument {

	Document document;
	Integer contentLength;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Integer getContentLength() {
		return contentLength;
	}

	public void setContentLength(Integer contentLength) {
		this.contentLength = contentLength;
	}

	public PageDocument(Document document, Integer contentLength) {
		super();
		this.document = document;
		this.contentLength = contentLength;
	}

	@Override
	public String toString() {
		return "PageDocument [document=" + document + ", contentLength=" + contentLength + "]";
	}

}
