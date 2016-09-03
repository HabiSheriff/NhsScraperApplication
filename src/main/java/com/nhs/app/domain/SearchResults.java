package com.nhs.app;

import java.util.List;

public class SearchResults {
	
	private String searchText;

	private List<String> matchedUrls;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public List<String> getMatchedUrls() {
		return matchedUrls;
	}

	public void setMatchedUrls(List<String> matchedUrls) {
		this.matchedUrls = matchedUrls;
	}

}
