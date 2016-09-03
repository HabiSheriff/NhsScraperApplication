package com.nhs.app.domain;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = -671813619741003950L;

	private String url;

	private String pageContent;

	private String title;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPageContent() {
		return pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Page [url=" + url + ", pageContent=" + pageContent + ", title=" + title + "]";
	}

}
