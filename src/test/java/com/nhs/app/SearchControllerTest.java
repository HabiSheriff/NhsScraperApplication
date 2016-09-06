package com.nhs.app;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.SearchResults;
import com.nhs.app.exception.ScraperException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchControllerTest implements ApplicationConstants {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void searchForMild() {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "mild");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString())
				.isEqualTo("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");

	}

	@Test
	public void searchForTextNotFound() {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "milddddddd");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString()).isEqualTo(RELEVANT_MATCH_NOT_FOUND);

	}
	
	@Test
	public void searchForTextTyphoidNotFound() {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "Typhoid");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString()).isEqualTo(RELEVANT_MATCH_NOT_FOUND);

	}
	
	@Test
	public void searchForFullTextCradleCap() throws ScraperException {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "cradle cap");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString())
				.isEqualTo("http://www.nhs.uk/conditions/cradle-cap/Pages/Introduction.aspx");
	}
	
	@Test
	public void searchForFullTextCroup() throws ScraperException {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "Symptoms for Croup");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString())
				.isEqualTo("http://www.nhs.uk/conditions/croup/Pages/Introduction.aspx");
	}
	@Test
	public void searchForFullTextADHD() throws ScraperException {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "Symptoms for Attention Deficit Hyperactivity Disorder");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString())
				.isEqualTo("http://www.nhs.uk/conditions/Attention-deficit-hyperactivity-disorder/Pages/Introduction.aspx");
	}
	@Test
	public void searchForFullTextImpetigo() throws ScraperException {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "Symptoms for impetigo");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString())
				.isEqualTo("http://www.nhs.uk/conditions/impetigo/Pages/Introduction.aspx");
	}
	@Test
	public void searchForFullTextMeasles() throws ScraperException {
		ResponseEntity<String> searchUrl = (ResponseEntity<String>) this.restTemplate
				.getForEntity("/search/{searchtext}", String.class, "Treatment for Measles");

		System.out.println(searchUrl);
		Assert.notNull(searchUrl);
		assertThat(searchUrl.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(searchUrl.getBody().toString())
				.isEqualTo("http://www.nhs.uk/conditions/measles/Pages/Introduction.aspx");
	}

}
