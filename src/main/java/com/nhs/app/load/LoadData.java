package com.nhs.app.load;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhs.app.GetDataService;

@Component
public class LoadData {

	@Autowired
	private GetDataService getDataService;

	@PostConstruct
	public void init() {
	}

}
