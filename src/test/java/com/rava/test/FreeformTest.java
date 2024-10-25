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
import com.rava.pages.FreeformPage;

public class FreeformTest extends BaseTest {
	private FreeformPage freeformpage = null;
	private static final Logger logger = Logger.getLogger(FreeformTest.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })
	public void goToSiteUrl(String siteURL, String browser) throws Exception {
		logger.info("Starting of Launch Url");
		driver = this.getWebDriver(browser, WEB_DRIVER.FREEFORM_DRIVER);
		this.goToSite(siteURL, driver);
		this.driver = this.getWebDriver(browser, WEB_DRIVER.FREEFORM_DRIVER);
		this.LoginWithPassword();
		logger.info("Ending of Launch Url");
	}

	@Test(priority = 1, description = "Verify Freeform feature")
	public void VerifyFreeformFeature() throws InterruptedException {

		logger.info("Starting of VerifyFreeformFeature method");
		freeformpage = new FreeformPage(driver);
		this.freeformpage = new FreeformPage(driver);

		this.freeformpage.clickOnCreateBtn();
		this.freeformpage.clickOnFreeformBtn();
		this.freeformpage.enterFreeformInput("Who is CM of Telangana");
		this.freeformpage.clickOnGenerateBtn();

		WebDriverWait waitName = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement businessInfoElement = waitName.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='miniChat result_answerTxt__XG3q3']")));

		String businessInfo = businessInfoElement.getText();
		String[] ss = businessInfo.split(":");
		logger.info("business-----------------" + ss);
		String expectedInfo = "Chief Minister of Telangana";

		Assert.assertEquals(ss[0], expectedInfo, "Information does not match!");

		logger.info("Ending of  VerifyFreeformFeature  method");
	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			this.quitDriver(WEB_DRIVER.FREEFORM_DRIVER);

		} catch (Exception e) {
			Assert.fail("Exception occured while quit : " + e.getMessage());
			logger.error("Error occured while quit", e);
		}

		logger.info("Ending of quitDriver method");
	}
}
