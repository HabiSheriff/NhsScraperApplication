package com.nhs.app.load;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhs.app.GetDataService;
import com.nhs.app.exception.ScraperException;

@Component
public class LoadData {
	
	private static final Logger logger = LoggerFactory.getLogger(LoadData.class);

	@Autowired
	private GetDataService getDataService;

	@PostConstruct
	public void init() throws ScraperException {
		
		logger.info(this.getClass().getSimpleName() + " - Loading the data");

		getDataService.getData();
	}

}
