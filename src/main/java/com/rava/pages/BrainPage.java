package com.rava.pages;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrainPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(BrainPage.class.getName());

	@FindBy(xpath = "//div[@class=' rounded-[4px] p-[7px] px-[10px]  font-medium flex items-center gap-[6px] hover:bg-[#f3f5f5]']//div[contains(text(),'Brain')]")
	private WebElement btnBrain;

	@FindBy(xpath = "(//div[contains(text(),'Company')])[1]")
	private WebElement btnCompany;

	@FindBy(xpath = "//div[@class= ' absolute top-1 right-0']")
	private WebElement drpdnBrand;

	@FindBy(xpath = "(//div[contains(text(),'Brand Voice')])[1]")
	private WebElement btnBrandvoice;

	@FindBy(xpath = "//button[contains(text(),'Create Voice')]")
	private WebElement btnCreatevoice;

	@FindBy(xpath = "//input[@id='people']")
	private WebElement txtBrandvoice;

	@FindBy(xpath = "//div[@class='overflow-y-auto custom-scrollbar']//button[contains(text(),'Create Brand Voice')]")
	private WebElement btnCreateBrandvoice;

	@FindBy(xpath = "(//input[@placeholder='Ex: Steve Jobs'])[1]")
	private WebElement txtBrandvoiceName;

	@FindBy(xpath = "(//button[text()='Save Brand Voice'])[1]")
	private WebElement btnSaveBrandvoice;

	@FindBy(xpath = "//div[@class='relative ']//img[@src=\"/images/chat/more-vert.svg\"]")
	private WebElement btnActions;

	@FindBy(xpath = "//div[@class='relative cursor-pointer']//img[1]")
	private WebElement btnActionsSnips;
	
	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	private WebElement btnEdit;

	@FindBy(xpath = "//img[@src='/images/company/mi_delete.svg']")
	private WebElement btnDelete;

	@FindBy(xpath = "//div[contains(text(),'Yes, I’m sure')]")
	private WebElement btnDeleteCnfirmtn;

	@FindBy(xpath = "//input[@placeholder='Ex: Rava AI Marketing']")
	private WebElement txtBrandVoiceUpdate;

	@FindBy(xpath = "//span[text()='Save Brand Voice']")
	private WebElement btnUpdateBrandVoice;

	@FindBy(xpath = "//div[contains(text(),'Text')]")
	private WebElement btnText;

	@FindBy(xpath = "//div[contains(text(),'URL')]")
	private WebElement btnUrl;

	@FindBy(xpath = "//div[contains(text(),'Attach')]")
	private WebElement btnAttach;

	@FindBy(xpath = "//textarea[@id='text']")
	private WebElement txtBrandvoiceExample;

	@FindBy(xpath = "//button[contains(text(),'Analyse text')]")
	private WebElement btnAnalyse;

	@FindBy(xpath = "(//input[@placeholder='Ex: Steve Jobs'])[2]")
	private WebElement txtBrandvoiceName2;

	@FindBy(xpath = "(//input[@placeholder='Ex: Steve Jobs'])[3]")
	private WebElement txtBrandvoiceName3;

	@FindBy(xpath = "(//input[@placeholder='Ex: Steve Jobs'])[4]")
	private WebElement txtBrandvoiceName4;

	@FindBy(xpath = "(//button[text()='Save Brand Voice'])[2]")
	private WebElement btnSaveBrandvoice2;

	@FindBy(xpath = "(//button[text()='Save Brand Voice'])[3]")
	private WebElement btnSaveBrandvoice3;
	
	@FindBy(xpath = "(//button[text()='Save Brand Voice'])[4]")
	private WebElement btnSaveBrandvoice4;

	@FindBy(xpath = "(//button[contains(text(),'Create Brand Voice')])[2]")
	private WebElement btnCreateBrandvoice2;

	@FindBy(xpath = "(//button[contains(text(),'Create Brand Voice')])[3]")
	private WebElement btnCreateBrandvoice3;

	@FindBy(xpath = "//input[@id='fileInput']")
	private WebElement btnUploadDoc;
	
	@FindBy(xpath = "//input[@name='url']")
	private WebElement txturl;
	
	@FindBy(xpath = "(//div[contains(@class,'flex item-center')])[3]")
	private WebElement btnSnips;
	
	@FindBy(xpath = "//button[text()='Create Snip']")
	private WebElement btnCreateSnips;
	
	@FindBy(xpath = "//input[@placeholder='title']")
	private WebElement txttite;
	
	@FindBy(xpath = "(//div[@class='ql-editor ql-blank'])[2]")
	private WebElement txtsnip;
	
	@FindBy(xpath = "//div[text()='Add Snip ']")
	private WebElement btnAddSnip;
	
	@FindBy(xpath = "//input[@placeholder='shortcut']")
	private WebElement txtShortcut;

	@FindBy(xpath = "//div[text()='Save Snip ']")
	private WebElement btnSaveSnip;
	
	public BrainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnBrainBtn() {
		logger.info("Starting of clickOnBrainBtn method");
		this.btnBrain.click();
		logger.info("Ending of clickOnBrainBtn method");
	}

	public void clickOnCompanyBtn() {
		logger.info("Starting of clickOnCompanyBtn method");
		this.btnCompany.click();
		logger.info("Ending of clickOnCompanyBtn method");
	}

	public void clickOnBrandDrpdwn() {
		logger.info("Starting of clickOnBrandDrpdwn method");
		this.drpdnBrand.click();
		logger.info("Ending of clickOnBrandDrpdwn method");
	}

	public void clickOnBrandVoice() {
		logger.info("Starting of clickOnBrandVoice method");
		this.btnBrandvoice.click();
		logger.info("Ending of clickOnBrandVoice method");
	}

	public void clickOnCreateVoice() {
		logger.info("Starting of clickOnCreateVoice method");
		this.btnCreatevoice.click();
		logger.info("Ending of clickOnCreateVoice method");
	}

	public void enteBrandVoice(String brandName) {
		logger.info("Starting of enteBrandVoice method");
		this.txtBrandvoice.sendKeys(brandName);
		logger.info("Ending of enteBrandVoice method");
	}

	public void clickOnCreateBrandVoice() {
		logger.info("Starting of clickOnCreateBrandVoice method");
		this.btnCreateBrandvoice.click();
		logger.info("Ending of clickOnCreateBrandVoice method");
	}

	public void clickOnCreateBrandVoiceOnUrl() {
		logger.info("Starting of clickOnCreateBrandVoiceOnUrl method");
		this.btnCreateBrandvoice2.click();
		logger.info("Ending of clickOnCreateBrandVoiceOnUrl method");
	}

	public void clickOnCreateBrandVoiceOnAttach() {
		logger.info("Starting of clickOnCreateBrandVoiceOnAttach method");
		this.btnCreateBrandvoice3.click();
		logger.info("Ending of clickOnCreateBrandVoiceOnAttach method");
	}

	public void enteBrandVoiceName(String brandName) {
		logger.info("Starting of enteBrandVoiceName method");
		this.txtBrandvoiceName.sendKeys(brandName);
		logger.info("Ending of enteBrandVoiceName method");
	}

	public void clickOnSaveBrandVoice() {
		logger.info("Starting of clickOnSaveBrandVoice method");
		this.btnSaveBrandvoice.click();
		logger.info("Ending of clickOnSaveBrandVoice method");
	}

	public void clickOnActionsBtn() {
		logger.info("Starting of clickOnActionsBtn method");
		this.btnActions.click();
		logger.info("Ending of clickOnActionsBtn method");
	}

	public void clickOnEditBtn() {
		logger.info("Starting of clickOnEditBtn method");
		this.btnEdit.click();
		logger.info("Ending of clickOnEditBtn method");
	}

	public void clickOnDeleteBtn() {
		logger.info("Starting of clickOnDeleteBtn method");
		this.btnDelete.click();
		logger.info("Ending of clickOnDeleteBtn method");

	}

	public void clickOnDeletecnfrmBtn() {
		logger.info("Starting of clickOnDeletecnfrmBtn method");
		this.btnDeleteCnfirmtn.click();
		logger.info("Ending of clickOnDeletecnfrmBtn method");
	}

	public void updateBrandVoiceName(String brandName) {
		logger.info("Starting of enteBrandVoiceName method");
		this.txtBrandVoiceUpdate.sendKeys(brandName);
		logger.info("Ending of enteBrandVoiceName method");
	}

	public void clickOnSaveBrandVoiceForUpdate() {
		logger.info("Starting of clickOnSaveBrandVoiceForUpdate method");
		this.btnUpdateBrandVoice.click();
		logger.info("Ending of clickOnSaveBrandVoiceForUpdate method");
	}

	public void clickOnTextTab() {
		logger.info("Starting of clickOnTextTab method");
		this.btnText.click();
		logger.info("Ending of clickOnTextTab method");
	}

	public void clickOnUrlTab() {
		logger.info("Starting of clickOnUrlTab method");
		this.btnUrl.click();
		logger.info("Ending of clickOnUrlTab method");
	}

	public void clickOnAttachTab() {
		logger.info("Starting of clickOnAttachTab method");
		this.btnAttach.click();
		logger.info("Ending of clickOnAttachTab method");
	}

	public void enterExampleText(String brandvoicetext) {
		logger.info("Starting of enterExampleText method");
		this.txtBrandvoiceExample.sendKeys(brandvoicetext);
		logger.info("Ending of enterExampleText method");
	}

	public void clickOnAnalyseTextBtn() {
		logger.info("Starting of clickOnAnalyseTextBtn method");
		this.btnAnalyse.click();
		logger.info("Ending of clickOnAnalyseTextBtn method");
	}

	public void enteBrandVoiceNameOnText(String brandName) {
		logger.info("Starting of enteBrandVoiceNameOnText method");
		this.txtBrandvoiceName2.sendKeys(brandName);
		logger.info("Ending of enteBrandVoiceNameOnText method");
	}

	public void enteBrandVoiceNameOnUrl(String brandName) {
		logger.info("Starting of enteBrandVoiceNameOnText method");
		this.txtBrandvoiceName3.sendKeys(brandName);
		logger.info("Ending of enteBrandVoiceNameOnText method");
	}

	public void enteBrandVoiceNameOnAttach(String brandName) {
		logger.info("Starting of enteBrandVoiceNameOnAttach method");
		this.txtBrandvoiceName4.sendKeys(brandName);
		logger.info("Ending of enteBrandVoiceNameOnAttach method");
	}

	public void clickOnSaveBrandVoiceforText() {
		logger.info("Starting of clickOnSaveBrandVoiceforText method");
		this.scrollIntoView(btnSaveBrandvoice2);
		this.btnSaveBrandvoice2.click();
		logger.info("Ending of clickOnSaveBrandVoiceforText method");
	}

	public void clickOnSaveBrandVoiceforUrl() {
		logger.info("Starting of clickOnSaveBrandVoiceforUrl method");
		this.scrollIntoView(btnSaveBrandvoice3);
		this.btnSaveBrandvoice3.click();
		logger.info("Ending of clickOnSaveBrandVoiceforUrl method");
	}

	public void clickOnSaveBrandVoiceforAttach() {
		logger.info("Starting of clickOnSaveBrandVoiceforAttach method");
		this.scrollIntoView(btnSaveBrandvoice4);
		this.btnSaveBrandvoice4.click();
		logger.info("Ending of clickOnSaveBrandVoiceforAttach method");
	}

	public void enterUrl(String url) {
		logger.info("Starting of enteBrandVoiceNameOnText method");
		this.txturl.sendKeys(url);
		logger.info("Ending of enteBrandVoiceNameOnText method");
	}

	public void UploadBrandVoiceFile(String UploadFile) {
		logger.info("Starting of clickOnUploadOnboardingFile method");

		btnUploadDoc.sendKeys(TEST_FILE_PATH + File.separator + UploadFile);

		logger.info("Ending of clickOnUploadOnboardingFile method");
	}
	public void clickOnSnipsTab() {
		logger.info("Starting of clickOnSnipsTab method");
		this.btnSnips.click();
		logger.info("Ending of clickOnSnipsTab method");
	}
	public void clickOnCreateSnips() {
		logger.info("Starting of clickOnCreateSnips method");
		this.btnCreateSnips.click();
		logger.info("Ending of clickOnCreateSnips method");
	}
	public void enterSnipsTitle(String title) {
		logger.info("Starting of enterSnipsTitle method");
		this.txttite.sendKeys(title);
		logger.info("Ending of enterSnipsTitle method");
	}
	public void enterSnipsDesc(String description) {
		logger.info("Starting of enterSnipsDesc method");
		this.txtsnip.sendKeys(description);
		logger.info("Ending of enterSnipsDesc method");
	}
	public void clickOnAddSnipBtn() {
		logger.info("Starting of clickOnAddSnipBtn method");
		this.btnAddSnip.click();
		logger.info("Ending of clickOnAddSnipBtn method");
	}
	public void clickOnSnipAction() {
		logger.info("Starting of clickOnSnipAction method");
		this.btnActionsSnips.click();
		logger.info("Ending of clickOnSnipAction method");
	}
	public void updateSnipstitle(String title) {
		logger.info("Starting of updateSnipstitle method");
		this.txtShortcut.sendKeys(title);
		logger.info("Ending of updateSnipstitle method");
	}
	
	public void clickOnSaveSnip() {
		logger.info("Starting of clickOnSaveSnip method");
		this.btnSaveSnip.click();
		logger.info("Ending of clickOnSaveSnip method");
	}
}
