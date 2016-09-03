package com.nhs.app.scraper;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhs.app.NhsScraperAppConfig;
import com.nhs.app.constants.ApplicationConstants;
import com.nhs.app.domain.Page;
import com.nhs.app.exception.ScraperException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { NhsScraperAppConfig.class })
public class ConditionSubPageScraperTest implements ApplicationConstants {

	@Autowired
	private ConditionSubPageScraper conditionSubPageScraper;

	@Test
	public void getConditionsSubPagesContentForChickpox() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(CHICKEN_POX_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);
		
		System.out.println("test 2");

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Chickenpox - NHS Choices");
		assertThat(page.getPageContent().contains("Chickenpox is a mild and common childhood"));
		assertThat(page.getPageContent()).isAtLeast("Chickenpox is a mild and common childhood");
	}
	
	@Test
	public void getConditionsSubPagesContentForThrush() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(THRUSH_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Vaginal thrush - NHS Choices");
		assertThat(page.getPageContent().contains("Vaginal thrush is a common yeast"));
		assertThat(page.getPageContent()).isAtLeast("Vaginal thrush is a common yeast");
	}

	@Test
	public void getConditionsSubPagesContentForDepression() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(DEPRESSION_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Clinical depression - NHS Choices");
		assertThat(page.getPageContent().contains("Clinical depression is more than simply feeling unhappy"));
		assertThat(page.getPageContent()).isAtLeast("Clinical depression is more than simply feeling unhappy");
	}
	
	@Test
	public void getConditionsSubPagesContentForSciatica() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(SCIATICA_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Sciatica - NHS Choices");
		assertThat(page.getPageContent().contains("Sciatica is the name given to any sort of pain that"));
		assertThat(page.getPageContent()).isAtLeast("Sciatica is the name given to any sort of pain that");
	}
	
	@Test
	public void getConditionsSubPagesContentForNoroVirus() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(NOROVIRUS_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Norovirus - NHS Choices");
		assertThat(page.getPageContent().contains("Norovirus, which causes diarrhoea and vomiting, is one"));
		assertThat(page.getPageContent()).isAtLeast("Norovirus, which causes diarrhoea and vomiting, is one");
	}
	
	@Test
	public void getConditionsSubPagesContentForDiabetes() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(DIABETES_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Type 2 diabetes - NHS Choices");
		assertThat(page.getPageContent().contains("Diabetes is a lifelong condition that causes a person's blood "));
		assertThat(page.getPageContent()).isAtLeast("Diabetes is a lifelong condition that causes a person's blood ");
	}
	@Test
	public void getConditionsSubPagesContentForBackPain() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(BACKPAIN_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Back pain - NHS Choices");
		assertThat(page.getPageContent().contains("Back pain is a common problem that affects"));
		assertThat(page.getPageContent()).isAtLeast("Back pain is a common problem that affects");
	}
	
	@Test
	public void getConditionsSubPagesContentForGlandularFever() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(GLANDULARFEVER_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Glandular fever - NHS Choices");
		assertThat(page.getPageContent().contains("Glandular fever is a type of viral infection that mostly"));
		assertThat(page.getPageContent()).isAtLeast("Glandular fever is a type of viral infection that mostly");
	}
	
	@Test
	public void getConditionsSubPagesContentForMenopause() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(MENOPAUSE_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Menopause - NHS Choices");
		assertThat(page.getPageContent().contains("The menopause is when a woman stops having periods"));
		assertThat(page.getPageContent()).isAtLeast("The menopause is when a woman stops having periods");
	}
	@Test
	public void getConditionsSubPagesContentForKidneyInfection() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(KIDNEYINFECTION_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Kidney infection - NHS Choices");
		assertThat(page.getPageContent().contains("A kidney infection (pyelonephritis) is a painful"));
		assertThat(page.getPageContent()).isAtLeast("A kidney infection (pyelonephritis) is a painful");
	}
	
	@Test
	public void getConditionsSubPagesContentForMeasles() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(MEASLES_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Measles - NHS Choices");
		assertThat(page.getPageContent().contains("Measles is a highly infectious viral illness that can be very"));
		assertThat(page.getPageContent()).isAtLeast("Measles is a highly infectious viral illness that can be very");
	}
	
	@Test
	public void getConditionsSubPagesContentForDiarrhoea() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(DIARRHOEA_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Diarrhoea - NHS Choices");
		assertThat(page.getPageContent().contains("Diarrhoea is passing looser or more frequent stools"));
		assertThat(page.getPageContent()).isAtLeast("Diarrhoea is passing looser or more frequent stools");
	}
	@Test
	public void getConditionsSubPagesContentForMumps() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(MUMPS_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Mumps - NHS Choices");
		assertThat(page.getPageContent().contains("Mumps is a contagious viral infection"));
		assertThat(page.getPageContent()).isAtLeast("Mumps is a contagious viral infection");
	}
	
	@Test
	public void getConditionsSubPagesContentForImpetigo() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(IMPETIGO_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Impetigo - NHS Choices");
		assertThat(page.getPageContent().contains("Impetigo is a common and highly contagious skin infection that causes"));
		assertThat(page.getPageContent()).isAtLeast("Impetigo is a common and highly contagious skin infection that causes");
	}
	@Test
	public void getConditionsSubPagesContentForSlappedCheekSyndrome() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(SLAPPEDCHEEKSYNDROME_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Slapped cheek syndrome - NHS Choices");
		assertThat(page.getPageContent().contains("Slapped cheek syndrome (also called fifth disease or parvovirus B19)"));
		assertThat(page.getPageContent()).isAtLeast("Slapped cheek syndrome (also called fifth disease or parvovirus B19)");
	}
	@Test
	public void getConditionsSubPagesContentForConstipation() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(CONSTIPATION_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Constipation - NHS Choices");
		assertThat(page.getPageContent().contains("Constipation is a common condition that affects"));
		assertThat(page.getPageContent()).isAtLeast("Constipation is a common condition that affects");
	}
	 
	@Test
	public void getConditionsSubPagesContentForAtopicEczema() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(ECZEMAATOPIC_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Atopic eczema - NHS Choices");
		assertThat(page.getPageContent().contains("Atopic eczema, also known as atopic dermatitis"));
		assertThat(page.getPageContent()).isAtLeast("Atopic eczema, also known as atopic dermatitis");
	}
	@Test
	public void getConditionsSubPagesContentForCroup() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(CROUP_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Croup - NHS Choices");
		assertThat(page.getPageContent().contains("Croup is a childhood condition that affects the windpipe"));
		assertThat(page.getPageContent()).isAtLeast("Croup is a childhood condition that affects the windpipe");
	}
	
	@Test
	public void getConditionsSubPagesContentForAttentionDeficitHyperactivityDisorder() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(ADHYPERACTIVITYDISORDER_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Attention deficit hyperactivity disorder (ADHD) - NHS Choices");
		assertThat(page.getPageContent().contains("Attention deficit hyperactivity disorder (ADHD) is a group of "));
		assertThat(page.getPageContent()).isAtLeast("Attention deficit hyperactivity disorder (ADHD) is a group of ");
	}
	
	@Test
	public void getConditionsSubPagesContentForCradleCap() throws ScraperException {
		Assert.assertNotNull(conditionSubPageScraper);
		Page page = conditionSubPageScraper.getConditionsSubPagesContent(CRADLECAP_NHS_PAGE,
				CONDITIONS_SUB_PAGE__CSS_STRING);

		Assert.assertNotNull(page);
		assertThat(page.getTitle()).isEqualTo("Cradle cap - NHS Choices");
		assertThat(page.getPageContent().contains("Cradle cap is the greasy, yellow scaly "));
		assertThat(page.getPageContent()).isAtLeast("Cradle cap is the greasy, yellow scaly ");
	}
}
