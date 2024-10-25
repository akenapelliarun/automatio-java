package com.rava.pages;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(OnboardingPage.class.getName());

	@FindBy(xpath = "//div[contains(text(),'Link')]")
	private WebElement btnlink;

	@FindBy(xpath = "//input[@id='url']")
	private WebElement txturl;

	@FindBy(xpath = "//button[contains(text(),'Scrape URL')]")
	private WebElement btnScrapeURL;

	@FindBy(xpath = "(//input[@placeholder='Enter Name'])[3]")
	private WebElement txtBusinessName2;

	@FindBy(xpath = "(//input[@placeholder='Enter Name'])[2]")
	private WebElement txtBusinessName3;

	@FindBy(xpath = "(//div[@class='bg-[#0c143d] rounded-[4px] flex items-center justify-center min-h-[24px] min-w-[24px] max-w-[24px] max-h-[24px] cursor-pointer'])[1]")
	private WebElement btnSelecturl;

	@FindBy(xpath = "//div[contains(text(), 'Save & Next')]")
	private WebElement btnSaveNexturl;

	@FindBy(xpath = "//button[contains(text(), 'Save & Next')]")
	private WebElement btnSaveNext;

	@FindBy(xpath = "//div[contains(text(),'Attachment')]")
	private WebElement txtAttachment;
	
	@FindBy(xpath = "//input[@id='fileInput']")
	private WebElement btnUploadDoc;

	@FindBy(xpath = "//button[contains(text(),'Create Company Brief')]")
	private WebElement btnCompanyBrief;
	
	@FindBy(xpath = "(//button[contains(text(), 'Go To Next Step')])[1]")
	private WebElement btnNxtStep;
	
	public OnboardingPage(WebDriver driver) {
		super(driver);

	}

	public void clickOnLinkBtn() {
		logger.info("Starting of clickOnLinkBtn method");
		this.btnlink.click();
		logger.info("Ending of clickOnLinkBtn method");

	}

	public void enterURL(String url) {
		logger.info("Starting of enterURL method");
		this.txturl.sendKeys(url);
		logger.info("Ending of enterURL method");

	}

	public void clickOnScrapURLBtn() {
		logger.info("Starting of clickOnScrapURLBtn method");
		this.btnScrapeURL.click();
		logger.info("Ending of clickOnScrapURLBtn method");

	}

	public void enterBusinessNameDoc(String name) {
		logger.info("Starting of enterBusinessNameDoc method");
		this.txtBusinessName2.sendKeys(name);
		logger.info("Ending of enterBusinessNameDoc method");

	}

	public void enterBusinessNameLink(String name) {
		logger.info("Starting of enterBusinessNameLink method");
		this.txtBusinessName3.sendKeys(name);
		logger.info("Ending of enterBusinessNameLink method");

	}

	public void clickOnSelectUrlBtn() {
		logger.info("Starting of clickOnSelectUrlBtn method");
		this.btnSelecturl.click();
		logger.info("Ending of clickOnSelectUrlBtn method");

	}

	public void clickOnSaveNextBtnForUrl() {
		logger.info("Starting of clickOnSaveNextBtn method");
		this.btnSaveNexturl.click();
		logger.info("Ending of clickOnSaveNextBtn method");
	}

	public void clickOnSaveNextBtn() {
		logger.info("Starting of clickOnSaveNextBtn method");
		this.btnSaveNext.click();
		logger.info("Ending of clickOnSaveNextBtn method");
	}

	public void clickOnAttachment() {
		logger.info("Starting of clickOnAttachment method");
		this.txtAttachment.click();
		logger.info("Ending of clickOnAttachment method");
	}

	public void clickOnUploadOnboardingFile(String UploadFile) {
		logger.info("Starting of clickOnUploadOnboardingFile method");

		btnUploadDoc.sendKeys(TEST_FILE_PATH + File.separator + UploadFile);

		logger.info("Ending of clickOnUploadOnboardingFile method");
	}
	public void clickOnComapnyBreif() {
		logger.info("Starting of clickOnComapnyBreif method");
		this.btnCompanyBrief.click();
		logger.info("Ending of clickOnComapnyBreif method");
	}
	public void clickOnNextStep() {
		logger.info("Starting of clickOnNextStep method");
		this.btnNxtStep.click();
		logger.info("Ending of clickOnNextStep method");
	}
}
