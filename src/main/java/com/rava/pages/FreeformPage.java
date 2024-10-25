package com.rava.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeformPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

	@FindBy(xpath = "//div[@class=\"relative border-[1px] border-[#fff]  false\"]")
	private WebElement btnCreate;

	@FindBy(xpath = "//div[@class='Layout_recentContainer__GCcyK']//div[contains(text(), 'Freeform')]")
	private WebElement txtFreeform;

	@FindBy(xpath = "//div[@class='custom-scrollbar boldClass  Editable_ProseMirror__R7r87 snippet_propClass3__xtQSa']")
	private WebElement txtFreeformInput;

	@FindBy(xpath = "//div[@class=\" z-20 w-full max-w-[92%] absolute pb-[8px]  bottom-0 flex items-center justify-between gap-2 bg-white\"]//div[contains(text(),'Generate')]\r\n")
	private WebElement btnGenerate;

	public FreeformPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateBtn() {
		logger.info("Starting of clickOnCreateBtn method");
		this.btnCreate.click();
		logger.info("Ending of clickOnCreateBtn method");
	}

	public void clickOnFreeformBtn() {
		logger.info("Starting of clickOnFreeformBtn method");
		this.txtFreeform.click();
		logger.info("Ending of clickOnFreeformBtn method");
	}

	public void enterFreeformInput(String email) {
		logger.info("Starting of enterFreeformInput method");
		this.txtFreeformInput.sendKeys(email);
		logger.info("Ending of enterFreeformInput method");
	}

	public void clickOnGenerateBtn() {
		logger.info("Starting of clickOnGenerateBtn method");
		this.btnGenerate.click();
		logger.info("Ending of clickOnGenerateBtn method");
	}
}
