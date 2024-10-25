package com.rava.test;

import java.time.Duration;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class OnboardingTest extends BaseTest {

	private LoginPage loginPage = null;
	private OnboardingPage onboardingPage = null;
	private static final Logger logger = Logger.getLogger(FreeformTest.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })
	public void goToSiteUrl(String siteURL, String browser) throws Exception {
		logger.info("Starting of Launch Url");
		driver = this.getWebDriver(browser, WEB_DRIVER.ONBOARDING_DRIVER);
		this.goToSite(siteURL, driver);
		this.driver = this.getWebDriver(browser, WEB_DRIVER.ONBOARDING_DRIVER);
		this.LoginWithPassword();
		logger.info("Ending of Launch Url");
	}

	@Test(priority = 1, description = "Verify Onboarding Using Text")

	@Parameters({ "siteURL" })
	public void onboardingUsingText(String siteURL) throws Exception {

		logger.info("Starting onboardingUsingText method");

		try {
			((JavascriptExecutor) driver).executeScript("window.open('" + siteURL + "/onboarding', '_blank');");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement onboardingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class=\"flex items-center justify-center m-auto mb-[48px]\"]")));
			Assert.assertTrue(onboardingElement.isDisplayed(), "Onboarding element is not displayed.");

			this.loginPage = new LoginPage(driver);
			this.onboardingPage = new OnboardingPage(driver);
			this.loginPage.enterBusinessName(testDataprop.getProperty("Business_Name"));
			this.loginPage.enterBusinessDescription(testDataprop.getProperty("Business_Description"));
			this.loginPage.clickOnGenrateStrategyBtn();
			this.onboardingPage.clickOnSaveNextBtn();

			WebDriverWait waituntils = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement element = waituntils.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class=\"text-[20px] font-semibold text-black \"]")));

			this.onboardingPage.clickOnNextStep();

			WebDriverWait waitforplan = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement elementPlan = waitforplan.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='flex flex-row items-center justify-center gap-[24px] px-[50px] py-[25px]']")));
			logger.info("Ending onboardingUsingText method");

		} catch (Exception e) {
			logger.error("Error in onboardingUsingLink method: " + e.getMessage(), e);
			throw e;
		} finally {
			driver.close();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
		}
	}

	@Test(priority = 2, description = "Verify Onboarding using Link")

	@Parameters({ "siteURL" })
	public void onboardingUsingLink(String siteURL) throws Exception {

		logger.info("Starting onboardingUsingLink method");

		try {
			this.loginPage = new LoginPage(driver);
			this.onboardingPage = new OnboardingPage(driver);

			((JavascriptExecutor) driver).executeScript("window.open('" + siteURL + "/onboarding', '_blank');");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement onboardingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class=\"flex items-center justify-center m-auto mb-[48px]\"]")));
			Assert.assertTrue(onboardingElement.isDisplayed(), "Onboarding element is not displayed.");

			this.onboardingPage.clickOnLinkBtn();
			this.onboardingPage.enterBusinessNameLink(testDataprop.getProperty("Business_Name"));
			this.onboardingPage.enterURL(testDataprop.getProperty("url"));
			this.onboardingPage.clickOnScrapURLBtn();
			this.onboardingPage.clickOnSelectUrlBtn();

			WebDriverWait waituntil = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement saveElement = waituntil.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Save & Next')]")));
			this.onboardingPage.clickOnSaveNextBtnForUrl();

			WebDriverWait waituntilSaveandNext = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement SaveandNextElement = waituntilSaveandNext.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Save & Next')]")));
			this.onboardingPage.clickOnSaveNextBtn();

			WebDriverWait waituntils = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement element = waituntils.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class=\"text-[20px] font-semibold text-black \"]")));

			this.onboardingPage.clickOnNextStep();

			WebDriverWait waitforplan = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement elementPlan = waitforplan.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='flex flex-row items-center justify-center gap-[24px] px-[50px] py-[25px]']")));

			logger.info("Ending onboardingUsingLink method");

		} catch (Exception e) {
			logger.error("Error in onboardingUsingLink method: " + e.getMessage(), e);
			throw e;
		} finally {
			driver.close();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
		}
	}

	@Test(priority = 3, description = "Verify Onboarding using Link")
	@Parameters({ "siteURL" })
	public void onboardingUsingDoc(String siteURL) throws Exception {

		logger.info("Starting onboardingUsingLink method");

		try {
			this.loginPage = new LoginPage(driver);
			this.onboardingPage = new OnboardingPage(driver);

			((JavascriptExecutor) driver).executeScript("window.open('" + siteURL + "/onboarding', '_blank');");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement onboardingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class=\"flex items-center justify-center m-auto mb-[48px]\"]")));
			Assert.assertTrue(onboardingElement.isDisplayed(), "Onboarding element is not displayed.");

			this.onboardingPage.clickOnAttachment();
			this.onboardingPage.enterBusinessNameDoc(testDataprop.getProperty("Business_Name"));
			this.onboardingPage.clickOnUploadOnboardingFile("Rava.pdf");
			WebDriverWait waituntilPdf = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement PdfElement = waituntilPdf.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='flex gap-[4px] items-center']")));

			this.onboardingPage.clickOnComapnyBreif();

			WebDriverWait waituntil = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement saveElement = waituntil.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Save & Next')]")));
			this.onboardingPage.clickOnSaveNextBtn();

			WebDriverWait waituntils = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement element = waituntils.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='text-[20px] font-semibold text-black ']")));

			this.onboardingPage.clickOnNextStep();

			WebDriverWait waitforplan = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement elementPlan = waitforplan.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='flex flex-row items-center justify-center gap-[24px] px-[50px] py-[25px]']")));

			logger.info("Ending onboardingUsingLink method");

		} catch (Exception e) {
			logger.error("Error in onboardingUsingLink method: " + e.getMessage(), e);
			throw e;
		} finally {
			driver.close();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
		}
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			this.quitDriver(WEB_DRIVER.ONBOARDING_DRIVER);

		} catch (Exception e) {
			Assert.fail("Exception occured while quit : " + e.getMessage());
			logger.error("Error occured while quit", e);
		}

		logger.info("Ending of quitDriver method");
	}
}
