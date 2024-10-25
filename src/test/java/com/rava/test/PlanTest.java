package com.rava.test;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rava.pages.LoginPage;
import com.rava.pages.OnboardingPage;
import com.rava.pages.PlanPage;


public class PlanTest extends BaseTest {

	private PlanPage planpage = null;
	private OnboardingPage onboardingPage = null;
	private LoginPage loginPage = null;

	private static final Logger logger = Logger.getLogger(PlanTest.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })
	public void goToSiteUrl(String siteURL, String browser) throws Exception {
		logger.info("Starting of Launch Url");
		driver = this.getWebDriver(browser, WEB_DRIVER.PLAN_DRIVER);
		this.goToSite(siteURL, driver);
		this.driver = this.getWebDriver(browser, WEB_DRIVER.PLAN_DRIVER);
		this.LoginWithPassword();
		logger.info("Ending of Launch Url");
	}
	
	@Test(priority = 1, description = "Verify Plan feature")
	public void VerifyStrategyGenerationFeature() throws Exception {
		try {
			logger.info("Starting of VerifyStrategyGenerationFeature");
			planpage = new PlanPage(driver);
			this.planpage = new PlanPage(driver);
			this.planpage.clickOnPlanTab();
			this.onboardingPage = new OnboardingPage(driver);
			this.onboardingPage = new OnboardingPage(driver);
			this.loginPage = new LoginPage(driver);
			this.loginPage.enterBusinessName(testDataprop.getProperty("Business_Name"));
			this.loginPage.enterBusinessDescription(testDataprop.getProperty("Business_Description"));
			this.planpage.clickOnCompanyBrief();
			this.planpage.clickOnSubmit();
			WebDriverWait waituntils = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement element = waituntils.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='text-[20px] font-semibold text-black ']")));
			this.planpage.clickOnCreateStrategy();
			WebDriverWait waituntilsPlan = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement Planelement = waituntilsPlan.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='RavaStrategy_strategyTxt__j0f9S']")));
		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifyStrategyGenerationFeature : " + e.getMessage());
			logger.error("Error occured while testing VerifyStrategyGenerationFeature", e);
		}

	}
	
	
	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			this.quitDriver(WEB_DRIVER.PLAN_DRIVER);

		} catch (Exception e) {
			Assert.fail("Exception occured while quit : " + e.getMessage());
			logger.error("Error occured while quit", e);
		}

		logger.info("Ending of quitDriver method");
	}
	
	
			
			
			
}
