package com.nhs.app.domain;

import java.io.Serializable;

public class SearchResults implements Serializable{
	

	private static final long serialVersionUID = 494397365394820943L;

	private String searchText;

	private String relevantMatchUrl;

	private float score;
	
	private boolean success;
	
	private String message;

	public String getRelevantMatchUrl() {
		return relevantMatchUrl;
	}

	public void setRelevantMatchUrl(String relevantMatchUrl) {
		this.relevantMatchUrl = relevantMatchUrl;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SearchResults [searchText=" + searchText + ", relevantMatchUrl=" + relevantMatchUrl + ", score=" + score
				+ "]";
	}

}
