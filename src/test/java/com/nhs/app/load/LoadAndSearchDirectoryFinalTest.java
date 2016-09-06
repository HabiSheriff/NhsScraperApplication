package com.nhs.app.load;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhs.app.NhsScraperAppConfig;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.domain.SearchResults;
import com.nhs.app.exception.ScraperException;
import com.nhs.app.scraper.ConditionPageScraper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NhsScraperAppConfig.class })
public class LoadAndSearchDirectoryFinalTest implements ApplicationConstants {

	@Autowired
	private LoadAndSearchDirectory loadAndSearchDirectoryFinal;

	@Autowired
	ConditionPageScraper conditionPageScraper;
	

	@Before
	public void setup() throws ScraperException {

		/*pages = new ArrayList<>();

		Page page1 = new Page();
		page1.setPageContent(
				"Chickenpox is a mild and common childhood illness that most children catch at some point.");
		page1.setTitle("Chickenpox");
		page1.setUrl("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");
		pages.add(page1);
		Assert.assertTrue(loadAndSearchDirectoryFinal.load(pages));*/

		Assert.assertTrue(loadAndSearchDirectoryFinal
						.load(conditionPageScraper.getConditionsPages(MAIN_NHS_PAGE, CONDITIONS_LI_CSS_STRING)));

	}

	@Test
	public void searchForMild() throws ScraperException {

		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("mild");

		Assert.assertNotNull(searchResults);
		Assert.assertNotNull(searchResults.getSearchText());
		assertThat(searchResults.getSearchText())
				.isEqualTo("mild");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");

	}

	@Test
	public void searchForFullTextChickenpox() throws ScraperException {

		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Chickenpox is a mild and common childhood illness that most children catch at some point.");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Chickenpox is a mild and common childhood illness that most children catch at some point.");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");

	}

	@Test
	public void searchForFullTextThrush() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("thrush");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("thrush");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Thrush/Pages/Introduction.aspx");

	}
	
	
	@Test
	public void searchForFullTextDepressionSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of depression");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of depression");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/depression/Pages/Introduction.aspx");

	}
	
	@Test
	public void searchForFullTextDepression() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("treatment for depression");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("treatment for depression");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/depression/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextSciatica() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("sciatica");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("sciatica");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/sciatica/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextSciaticaSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms for sciatica");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms for sciatica");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/sciatica/Pages/Introduction.aspx");

	}
	
	@Test
	public void searchForFullTextNorovirus() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("norovirus");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("norovirus");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/norovirus/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextNorovirusSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms for Norovirus");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms for Norovirus");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/norovirus/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextDiabetes() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Diabetes");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Diabetes");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Diabetes-type2/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextDiabetesSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of Diabetes");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of Diabetes");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Diabetes-type2/Pages/Introduction.aspx");

	}
	
	@Test
	public void searchForFullTextBackPain() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Back Pain");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Back Pain");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/sciatica/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextBackPainSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of Back-Pain");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of Back-Pain");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/chickenpox/Pages/Introduction.aspx");

	}
	
	@Test
	public void searchForFullTextGlandularFever() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Glandular Fever");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Glandular Fever");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/glandular-fever/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextGlandularFeverSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of Glandular Fever");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of Glandular Fever");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/glandular-fever/Pages/Introduction.aspx");

	}
	
	@Test
	public void searchForFullTextMenopause() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Menopause");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Menopause");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/menopause/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextMenopauseSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of Menopause");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of Menopause");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/menopause/Pages/Introduction.aspx");

	} 
	
	@Test
	public void searchForFullTextKidneyInfection() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Kidney Infection");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Kidney Infection");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Kidney-infection/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextKidneyinfectionSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of Kidney Infection");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of Kidney Infection");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Kidney-infection/Pages/Introduction.aspx");

	}  
	
	@Test
	public void searchForFullTextMeasles() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Measles");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Measles");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/measles/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextMeaslesSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of Measles");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of Measles");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/measles/Pages/Introduction.aspx");

	} 
	@Test
	public void searchForFullTextDiarrhoeaSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms of Diarrhoea");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms of Diarrhoea");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/norovirus/Pages/Introduction.aspx");

	}  
	
	@Test
	public void searchForFullTextDiarrhoea() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Diarrhoea");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Diarrhoea");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/norovirus/Pages/Introduction.aspx");

	}
	
	
	
	@Test
	public void searchForFullTextMumps() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("mumps");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("mumps");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/glandular-fever/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextImpetigoSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms for Impetigo");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms for Impetigo");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/impetigo/Pages/Introduction.aspx");

	}  
	
	@Test
	public void searchForFullTextImpetigo() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Impetigo");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Impetigo");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/impetigo/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextSlappedCheekSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms for slapped cheek syndrome");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms for slapped cheek syndrome");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/slapped-cheek-syndrome/Pages/Introduction.aspx");

	}  
	
	
	@Test
	public void searchForFullTextSlappedCheek() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("slapped cheek");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("slapped cheek");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/slapped-cheek-syndrome/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextConstipation() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Constipation");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Constipation");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Kidney-infection/Pages/Introduction.aspx");

	}
	
	
	@Test
	public void searchForFullTextEczemaatopic() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Eczema atopic");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Eczema atopic");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Eczema-(atopic)/Pages/Introduction.aspx");

	}
	  
	
	@Test
	public void searchForFullTextCroup() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Croup");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Croup");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/croup/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextCroupSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms for Croup");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms for Croup");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/croup/Pages/Introduction.aspx");

	}  
	
	@Test
	public void searchForFullTextAttentionDeficitHyperactivityDisorder() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Attention Deficit Hyperactivity Disorder");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Attention Deficit Hyperactivity Disorder");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Attention-deficit-hyperactivity-disorder/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextAttentionDeficitHyperactivityDisorderSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms for Attention Deficit Hyperactivity Disorder");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms for Attention Deficit Hyperactivity Disorder");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/Attention-deficit-hyperactivity-disorder/Pages/Introduction.aspx");

	} 
	
	@Test
	public void searchForFullTextCradleCap() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("cradle cap");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("cradle cap");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/cradle-cap/Pages/Introduction.aspx");

	}
	@Test
	public void searchForFullTextCradleCapSymptoms() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("Symptoms for cradle cap");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("Symptoms for cradle cap");
		Assert.assertNotNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getRelevantMatchUrl())
				.isEqualTo("http://www.nhs.uk/conditions/cradle-cap/Pages/Introduction.aspx");

	}  
	
	
	@Test
	public void searchForFullTextCradleCapNotFound() throws ScraperException {
		Assert.assertNotNull(loadAndSearchDirectoryFinal);

		SearchResults searchResults = loadAndSearchDirectoryFinal
				.search("cradleeee");

		Assert.assertNotNull(searchResults);
		assertThat(searchResults.getSearchText())
				.isEqualTo("cradleeee");
		Assert.assertNull(searchResults.getRelevantMatchUrl());
		assertThat(searchResults.getMessage()).isEqualTo(RELEVANT_MATCH_NOT_FOUND);
		

	}  
	@Test(expected = NullPointerException.class)
	public void loadDirectoryWithNullPage() throws ScraperException, ParseException {
		loadAndSearchDirectoryFinal.search(null);

	}

	

}
