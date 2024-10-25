package com.rava.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseAutomationPage {
    private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

    @FindBy(xpath= "//div[@class='Login_googleTxt__oUFS9']")
    private WebElement btnGoogleLogin;
    
    @FindBy(xpath= "//input[@type='email']")
    private WebElement txtemail;
    
    @FindBy(xpath= "//span[contains(text(), 'Next')]")
    private WebElement btnnext;
    
    @FindBy(xpath= "//input[@type='password']")
    private WebElement txtpswrd;
    
    @FindBy(xpath= "//button[contains(text(), 'Login')]")
    private WebElement btnLogin;
    
    @FindBy(xpath= "(//input[@placeholder='Enter Name'])[1]")
    private WebElement txtBusinessName;
        
    @FindBy(xpath= "//textarea[@id='business-description']")
    private WebElement txtBusinessDescription;
    
    @FindBy(xpath= "//button[contains(text(), 'Generate Strategy')]")
    private WebElement btnGenerateStrategy;
    
    @FindBy(xpath= "//button[contains(text(), 'Save & Next')]")
    private WebElement btnSaveNext;
 
    
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnGoogleLoginBtn() {
        logger.info("Starting of clickOnGoogleLoginBtn method");
        this.btnGoogleLogin.click();
        logger.info("Ending of clickOnGoogleLoginBtn method");
    }
    
    public void enterEmail(String email) {
        logger.info("Starting of enterEmail method");
        this.txtemail.sendKeys(email);
        logger.info("Ending of enterEmail method");
    }
    public void enterPassword(String pswrd) {
        logger.info("Starting of enterPassword method");
        this.txtpswrd.sendKeys(pswrd);
        logger.info("Ending of enterPassword method");
    }
    public void clickOnNextBtn() {
        logger.info("Starting of clickOnNextBtn method");
        this.btnnext.click();
        logger.info("Ending of clickOnNextBtn method");
    }
    public void clickOnLoginBtn() {
        logger.info("Starting of clickOnLoginBtn method");
        this.btnLogin.click();
        logger.info("Ending of clickOnLoginBtn method");
    }
    
    public void enterBusinessName(String name) {
        logger.info("Starting of enterBusinessName method");
        this.txtBusinessName.sendKeys(name);
        logger.info("Ending of enterBusinessName method");
    }
    
    public void enterBusinessDescription(String description) {
        logger.info("Starting of enterBusinessDescription method");
        this.txtBusinessDescription.sendKeys(description);
        logger.info("Ending of enterBusinessDescription method");
    }
    
    public void clickOnGenrateStrategyBtn() {
        logger.info("Starting of clickOnGenrateStrategyBtn method");
        this.btnGenerateStrategy.click();
        logger.info("Ending of clickOnGenrateStrategyBtn method");
    }
  
}

