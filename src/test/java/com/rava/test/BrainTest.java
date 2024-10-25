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
import com.rava.pages.BrainPage;

public class BrainTest extends BaseTest {

	private BrainPage brainpage = null;
	private static final Logger logger = Logger.getLogger(BrainTest.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })
	public void goToSiteUrl(String siteURL, String browser) throws Exception {
		logger.info("Starting of Launch Url");
		
		driver = this.getWebDriver(browser, WEB_DRIVER.BRAIN_DRIVER);
		
		this.goToSite(siteURL, driver);
		this.driver = this.getWebDriver(browser, WEB_DRIVER.BRAIN_DRIVER);
		this.LoginWithPassword();
		logger.info("Ending of Launch Url");
	}

	@Test(priority = 1, description = "Verify Company feature")
	public void VerifyCompanyPage() throws Exception {
		try {
			logger.info("Starting of VerifyCompanyPage");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			Thread.sleep(3000);
			this.brainpage.clickOnBrainBtn();
			Thread.sleep(1000);
			this.brainpage.clickOnCompanyBtn();
			Thread.sleep(1000);
			WebDriverWait waitDescription = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement DescriptionElement = waitDescription.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[contains(@class,'leading-[20px] tracking-normal')])[3]")));
			String DescriptionElemen = DescriptionElement.getText();
			String expectedInfo = "Rava.ai is a comprehensive AI-powered marketing platform specifically designed to assist startups and small businesses in their marketing efforts. The platform offers a wide range of services, including automated content creation, market analysis using AI, strategy development tailored to specific business needs, and personalized marketing messages for Account-Based Marketing (ABM).";
			logger.info("Ending VerifyCompanyPage method");
		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifyBrandVoiceCreationWithDynamic : " + e.getMessage());
			logger.error("Error occured while testing VerifyBrandVoiceCreationWithDynamic", e);
		}

	}

	@Test(priority = 2, description = "Verify Brandvoice feature")
	public void VerifyBrandVoiceCreationWithDynamic() throws Exception {
		try {
			logger.info("Starting of VerifyBrandVoiceCreationWithDynamic");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			this.brainpage.clickOnBrandDrpdwn();
			this.brainpage.clickOnBrandVoice();
			this.brainpage.clickOnCreateVoice();
			this.brainpage.enteBrandVoice(testDataprop.getProperty("Brand_Voice_Topic"));
			this.brainpage.clickOnCreateBrandVoice();

			Thread.sleep(2000);
			this.brainpage.enteBrandVoiceName(testDataprop.getProperty("Brand_Voice_Topic"));

			WebDriverWait waitforBrandvoice = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement elementBrandVoice = waitforBrandvoice.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//button[text()='Save Brand Voice'])[1]")));
			Thread.sleep(5000);
			this.brainpage.clickOnSaveBrandVoice();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifyBrandVoiceCreationWithDynamic : " + e.getMessage());
			logger.error("Error occured while testing VerifyBrandVoiceCreationWithDynamic", e);
		}

	}

	@Test(priority = 3, description = "Verify Brandvoice feature")
	public void VerifyBrandVoiceUpdateAndDelettion() throws Exception {
		try {
			logger.info("Starting of VerifyBrandVoiceUpdateAndDelettion");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			this.brainpage.clickOnActionsBtn();
			this.brainpage.clickOnEditBtn();
			this.brainpage.updateBrandVoiceName(testDataprop.getProperty("Brand_Voice_Topic_EDIT"));
			this.brainpage.clickOnSaveBrandVoiceForUpdate();
			Thread.sleep(3000);
			this.brainpage.clickOnActionsBtn();
			this.brainpage.clickOnDeleteBtn();
			this.brainpage.clickOnDeletecnfrmBtn();
			Thread.sleep(3000);
			WebElement successMessage = driver
					.findElement(By.xpath("//*[contains(text(), 'Brand voice deleted successfully')]"));
			Assert.assertNotNull(successMessage,
					"The success message 'Brand voice deleted successfully' was not displayed.");

		} catch (Exception e) {
			Assert.fail("Exception occured while VerifyBrandVoiceUpdateAndDelettion VerifyBrandVoiceUpdate : "
					+ e.getMessage());
			logger.error("Error occured while testing VerifyBrandVoiceUpdateAndDelettion", e);
		}
	}

	@Test(priority = 4, description = "Verify Brandvoice feature")
	public void VerifyBrandVoiceCreationWithtext() throws Exception {
		try {
			logger.info("Starting of VerifyBrandVoiceCreationWithtext");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			this.brainpage.clickOnCreateVoice();
			this.brainpage.clickOnTextTab();
			this.brainpage.enterExampleText(testDataprop.getProperty("Brand_Voice_Description"));
			this.brainpage.clickOnAnalyseTextBtn();
			this.brainpage.enteBrandVoiceNameOnText(testDataprop.getProperty("Brand_Voice_Topic"));

			Thread.sleep(5000);
			WebDriverWait waitforBrandvoice = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement elementBrandVoice = waitforBrandvoice.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//button[text()='Save Brand Voice'])[2]")));
			Thread.sleep(5000);
			this.scrollToBottom();
			this.brainpage.clickOnSaveBrandVoiceforText();

			VerifyBrandVoiceUpdateAndDelettion();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifyBrandVoiceCreationWithDynamic : " + e.getMessage());

			logger.error("Error occured while testing VerifyBrandVoiceCreationWithDynamic", e);
		}

	}

	@Test(priority = 5, description = "Verify Brandvoice feature")
	public void VerifyBrandVoiceCreationWithurl() throws Exception {
		try {
			logger.info("Starting of VerifyBrandVoiceCreationWithurl");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			this.brainpage.clickOnCreateVoice();
			this.brainpage.clickOnUrlTab();
			this.brainpage.enterUrl(testDataprop.getProperty("url"));
			this.brainpage.clickOnCreateBrandVoiceOnUrl();
			this.brainpage.enteBrandVoiceNameOnUrl(testDataprop.getProperty("Brand_Voice_Topic"));
			Thread.sleep(5000);
			WebDriverWait waitforBrandvoice = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement elementBrandVoice = waitforBrandvoice.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//button[text()='Save Brand Voice'])[3]")));
			Thread.sleep(4000);
			this.scrollToBottom();
			this.brainpage.clickOnSaveBrandVoiceforUrl();

			VerifyBrandVoiceUpdateAndDelettion();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifyBrandVoiceCreationWithurl : " + e.getMessage());

			logger.error("Error occured while testing VerifyBrandVoiceCreationWithurl", e);
		}

	}

	@Test(priority = 6, description = "Verify Brandvoice feature")
	public void VerifyBrandVoiceCreationWithAttach() throws Exception {
		try {
			logger.info("Starting of VerifyBrandVoiceCreationWithAttach");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			this.brainpage.clickOnCreateVoice();
			this.brainpage.clickOnAttachTab();
			this.brainpage.UploadBrandVoiceFile("Rava.pdf");
			WebDriverWait waituntilPdf = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement PdfElement = waituntilPdf.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='flex gap-[4px] items-center']")));
			this.brainpage.clickOnCreateBrandVoiceOnAttach();
			this.brainpage.enteBrandVoiceNameOnAttach(testDataprop.getProperty("Brand_Voice_Topic"));
			WebDriverWait waitforBrandvoice = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement elementBrandVoice = waitforBrandvoice.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("//button[@class=\"px-[16px] flex items-center justify-center py-[8px] rounded-[4px] text-[14px] my-[16px] false bg-gradient-to-r from-primaryPink to-[#6b6cff] text-white w-[200px] !mb-0 \"]")));
			this.scrollToBottom();
			this.brainpage.clickOnSaveBrandVoiceforAttach();

			VerifyBrandVoiceUpdateAndDelettion();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifyBrandVoiceCreationWithAttach : " + e.getMessage());

			logger.error("Error occured while testing VerifyBrandVoiceCreationWithAttach", e);
		}

	}

	@Test(priority = 7, description = "Verify Snips feature")
	public void VerifySnipsCreation() throws Exception {
		try {
			logger.info("Starting of VerifySnipsCreation");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			this.brainpage.clickOnSnipsTab();
			this.brainpage.clickOnCreateSnips();
			this.brainpage.enterSnipsTitle(testDataprop.getProperty("Brand_Voice_Topic"));
			this.brainpage.enterSnipsDesc(testDataprop.getProperty("Snips_Description"));
			this.brainpage.clickOnAddSnipBtn();

			WebElement successMessage = driver
					.findElement(By.xpath("//div[contains(text(), 'Snip created successfully')]"));
			Assert.assertNotNull(successMessage, "The success message 'Snip created successfully' was not displayed.");

		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifySnipsCreation : " + e.getMessage());

			logger.error("Error occured while testing VerifySnipsCreation", e);
		}

	}

	@Test(priority = 8, description = "Verify SnipsUpdate feature")
	public void VerifySnipsUpdateAndDelete() throws Exception {
		try {
			logger.info("Starting of VerifySnipsUpdateAndDelete");
			brainpage = new BrainPage(driver);
			this.brainpage = new BrainPage(driver);
			this.brainpage.clickOnSnipAction();
			this.brainpage.clickOnEditBtn();
			this.brainpage.updateSnipstitle(testDataprop.getProperty("Brand_Voice_Topic_EDIT"));
			this.brainpage.clickOnSaveSnip();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement successMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[contains(text(), 'Snip updated successfully')]")));
			Assert.assertNotNull(successMessage, "The success message 'Snip updated successfully' was not displayed.");

			this.brainpage.clickOnSnipAction();
			this.brainpage.clickOnDeleteBtn();
			this.brainpage.clickOnDeletecnfrmBtn();
			WebElement deleteMessage = driver
					.findElement(By.xpath("//div[contains(text(), 'Snip deleted successfully')]"));
			Assert.assertNotNull(deleteMessage, "The success message 'Snip deleted successfully' was not displayed.");

		} catch (Exception e) {
			Assert.fail("Exception occured while testing VerifySnipsUpdateAndDelete : " + e.getMessage());

			logger.error("Error occured while testing VerifySnipsUpdateAndDelete", e);
		}

	}

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			this.quitDriver(WEB_DRIVER.BRAIN_DRIVER);

		} catch (Exception e) {
			Assert.fail("Exception occured while quit : " + e.getMessage());
			logger.error("Error occured while quit", e);
		}

		logger.info("Ending of quitDriver method");
	}
}
