package com.rava.test;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rava.pages.LoginPage;

public class LoginTest extends BaseTest {

	WebDriver driver = null;
	private LoginPage loginPage = null;
	private static final Logger logger = Logger.getLogger(LoginTest.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser"})
	public void goToSiteUrl(String siteURL, String browser) throws Exception {
		logger.info("Starting of Launch Url");
		
		driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.goToSite(siteURL, driver);

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);

		logger.info("Ending of of Launch Url");
	}

//	@Test(priority = 1, description = "Verify Googlelogin")
////    @Description("Test Description:Verify Googlelogin")
////    @Severity(SeverityLevel.MINOR)
////	@Story("Verify Googlelogin")
//
//	public void Googlelogin() throws InterruptedException {
//		logger.info("Starting of Google login method");
//
//		this.loginPage.clickOnGoogleLoginBtn();
//		Thread.sleep(3000);
//		String mainWindowHandle = driver.getWindowHandle();
//		Set<String> allWindowHandles = driver.getWindowHandles();
//		for (String windowHandle : allWindowHandles) {
//			if (!windowHandle.equals(mainWindowHandle)) {
//				driver.switchTo().window(windowHandle);
//				break;
//			}
//		}
//
//		this.loginPage.enterEmail("arunakenapelli@gmail.com");
//		this.loginPage.clickOnNextBtn();
//		Thread.sleep(5000);
//		this.loginPage.enterPassword("Abhi@9849");
//		this.loginPage.clickOnNextBtn();
//		Thread.sleep(6000);
//
//		logger.info("Ending of  Google login  method");
//
//	}

	@Test(priority = 1, description = "Verify LoginWithPassword")
	public void LoginWithPassword() throws InterruptedException {

		logger.info("Starting of LoginWithPassword method");
		loginPage = new LoginPage(driver);
		this.loginPage = new LoginPage(driver);
		this.loginPage.enterEmail("qa@rava.ai");
		this.loginPage.enterPassword("Rava@1234");
		this.loginPage.clickOnLoginBtn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@class='SideMenu_shadowMenu__XrG1k flex items-center gap-[6px] rounded-[8px] p-[6px] bg-white']")));
		Assert.assertTrue(Menu.isDisplayed(), "Menu is not displayed after login.");

		logger.info("Ending of  LoginWithPassword  method");
	}

	/*
	 * @Test(priority = 2, description = "Verify Onboarding") public void
	 * onboarding() throws InterruptedException {
	 * 
	 * logger.info("Starting of onboarding method");
	 * 
	 * ((JavascriptExecutor) driver).
	 * executeScript("window.open('https://app.rava.ai/onboarding', '_blank');");
	 * ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	 * driver.switchTo().window(tabs.get(1));
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * WebElement onboardingElement =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated( By.
	 * xpath("//div[@class=\"flex items-center justify-center m-auto mb-[48px]\"]"))
	 * ); Assert.assertTrue(onboardingElement.isDisplayed(),
	 * "Onboarding element is not displayed.");
	 * 
	 * this.loginPage.enterBusinessName("Rava.ai");
	 * this.loginPage.enterBusinessDescription(
	 * "Rava.ai provides advanced AI solutions to automate business processes, enhance productivity, and drive growth. Our offerings include AI-powered customer support, predictive analytics, robotic process automation, document processing, and sales and marketing automation. We help businesses streamline operations and achieve a competitive edge with tailored, reliable, and innovative AI technologies."
	 * ); this.loginPage.clickOnGenrateStrategyBtn();
	 * 
	 * this.loginPage.clickOnSaveNextBtn();
	 * 
	 * WebDriverWait waitName = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * WebElement businessInfoElement =
	 * waitName.until(ExpectedConditions.visibilityOfElementLocated(
	 * By.xpath("//div[@class='text-[40px] text-[#000] font-semibold mb-[16px]']")))
	 * ;
	 * 
	 * String businessInfo = businessInfoElement.getText();
	 * 
	 * String expectedInfo = "Here is your Company Business Information";
	 * 
	 * Assert.assertEquals(businessInfo, expectedInfo,
	 * "Business information does not match!"); Thread.sleep(5000);
	 * 
	 * logger.info("Ending of onboarding method");
	 * 
	 * driver.close(); driver.switchTo().window(tabs.get(0)); }
	 */

	@AfterClass
	public void quitDriver() {
		logger.info("Starting of quitDriver method");

		try {
			this.quitDriver(WEB_DRIVER.LOGIN_DRIVER);

		} catch (Exception e) {
			Assert.fail("Exception occured while quit : " + e.getMessage());
			logger.error("Error occured while quit", e);
		}

		logger.info("Ending of quitDriver method");
	}
}
