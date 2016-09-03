package com.nhs.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoadData {

	@Autowired
	private GetDataService getDataService;

	@PostConstruct
	public void init() {
	}

}
