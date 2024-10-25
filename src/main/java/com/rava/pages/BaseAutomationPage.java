package com.rava.pages;


import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public abstract class BaseAutomationPage {

	protected WebDriver driver;

	private static final Logger logger = Logger.getLogger(BaseAutomationPage.class.getName());

	public static String TEST_FILE_PATH;

	private Actions action;

	public BaseAutomationPage() {
		super();
	}

	protected BaseAutomationPage(WebDriver driver) {
		this.driver = driver;

		if (TEST_FILE_PATH == null) {

			TEST_FILE_PATH = getTestFilePath();

			logger.debug("In Constructor " + TEST_FILE_PATH);
		}

		PageFactory.initElements(driver, this);
	}

	public enum WEB_ACTIONS {
		CLICK, VISIBILE, TEXT
	}

	protected void selectDropdown(String xpath, String value) {
		Select conditions = new Select(driver.findElement(By.xpath(xpath)));
		conditions.selectByValue(value);

	}

	protected String getTestFilePath() {
		String path = "src/main/resources";
		File file = new File(path);
		return file.getAbsolutePath();
	}

	protected void scrollDown(int scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + scroll + ")");
	}

	protected void refresh() {
		driver.navigate().refresh();
	}

	protected WebElement findElement(WebElement webelement, WEB_ACTIONS webActions) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		switch (webActions) {
		case CLICK:
			wait.until(ExpectedConditions.elementToBeClickable(webelement));
			break;
		case VISIBILE:
			wait.until(ExpectedConditions.visibilityOf(webelement));
			break;
		default:
			wait.until(ExpectedConditions.visibilityOf(webelement));
		}
		return webelement;
	}

	protected void clickOnWebElement(WebElement webelement) {
		findElement(webelement, WEB_ACTIONS.CLICK);

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].click();", webelement);
	}

	protected String getText(WebElement webelement) {
		return findElement(webelement, WEB_ACTIONS.VISIBILE).getText();
	}

	protected void sendKeys(WebElement webelement, String keys) {
		findElement(webelement, WEB_ACTIONS.VISIBILE).sendKeys(keys);
	}

	protected void clearText(WebElement webelement) {
		findElement(webelement, WEB_ACTIONS.VISIBILE).clear();
	}

	protected void pickFromWebElemetList(List<WebElement> webElements, String containsText) {
		for (WebElement webElement : webElements) {
			if (webElement.getText().contains(containsText)) {
				this.clickOnWebElement(webElement);
				break;
			}
		}
	}

	protected void pickFromWebElemetList(List<WebElement> webElements, List<WebElement> textWebElements,
			String containsText) {
		WebElement webElement = null;
		WebElement textWebElement = null;
		Object[] webElementsArray = webElements.toArray();
		Object[] xPathArray = textWebElements.toArray();

		for (int i = 0; i < webElements.size(); i++) {
			webElement = (WebElement) webElementsArray[i];
			textWebElement = (WebElement) xPathArray[i];
			if (textWebElement.getText().contains(containsText)) {
				this.clickOnWebElement(webElement);
				break;
			}
		}

	}

	protected void sendKeysUsingJavaScript(String value, WebElement element) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + value + "';", element);

	}

	protected void dragAndSort(List<WebElement> webElementList, Integer targetIndex, Integer destIndex) {
		action = new Actions(driver);
		WebElement target = webElementList.get(0);
		WebElement dest = webElementList.get(3);
		action.click(target).clickAndHold().moveToElement(dest).moveByOffset(0, 10).release().build().perform();
	}

	protected void NavigateBack() {
		driver.navigate().back();
	}
	
	public void scrollIntoView(WebElement element) {
		logger.info("Starting of scrollIntoView method");

		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("arguments[0].scrollIntoView(true);", element);

		logger.info("Ending of scrollIntoView method");
	}

	protected void mouseHover(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	protected void switchToNewWindow() {
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	protected void closeWindow() {
		driver.close();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	protected void dropdownElement(int count, WebElement webElement) {
		for (int i = 0; i <= count; i++) {
			try {
				clickOnWebElement(webElement);

			} catch (StaleElementReferenceException e) {

			}
		}

	}

}