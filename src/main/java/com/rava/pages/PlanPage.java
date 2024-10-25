package com.rava.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanPage extends BaseAutomationPage {
	
	private static final Logger logger = Logger.getLogger(PlanPage.class.getName());

	@FindBy(xpath = "//div[contains(text(),'Plan')]")
	private WebElement btnPlan;
	
	@FindBy(xpath = "(//div[@class=\"RavaStrategy_generateBtn__O9Dp2\"])[1]")
	private WebElement btnGenerateBA;
	
	@FindBy(xpath = "(//button[contains(text(),'Create Company Brief')])[1]")
	private WebElement btnCompanyBrief;

	@FindBy(xpath = "//button[contains(text(), 'Submit')]")
	private WebElement btnSubmit;
	
	@FindBy(xpath = "//button[contains(text(), 'Create Strategy')]")
	private WebElement btnCreateStrategy;
	
	
	
	public PlanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnPlanTab() {
		logger.info("Starting of clickOnPlanTab method");
		this.btnPlan.click();
		logger.info("Ending of clickOnPlanTab method");
	}
	
	public void clickOnGenerateForBusinessAnalysis() {
		logger.info("Starting of clickOnGenerateForBusinessAnalysis method");
		this.btnPlan.click();
		logger.info("Ending of clickOnGenerateForBusinessAnalysis method");
	}

	public void clickOnCompanyBrief() {
	
		logger.info("Starting of clickOnCompanyBrief method");
		this.btnCompanyBrief.click();
		logger.info("Ending of clickOnCompanyBrief method");
	}
	public void clickOnSubmit() {
		logger.info("Starting of clickOnSubmit method");
		this.btnSubmit.click();
		logger.info("Ending of clickOnSubmit method");
	}
	public void clickOnCreateStrategy() {
		logger.info("Starting of clickOnCreateStrategy method");
		this.btnCreateStrategy.click();
		logger.info("Ending of clickOnCreateStrategy method");
	}
}
