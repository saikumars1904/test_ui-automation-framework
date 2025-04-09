package com.utility;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	public WebDriver getDriver() {
		return driver.get();
	}


	public void setDriver(WebDriver driver) {
		BrowserUtility.driver.set(driver);
	}


	public BrowserUtility(WebDriver driver) {
		BrowserUtility.driver.set(driver);
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("opening the browser {}",browserName);
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver()) ;
		}
		
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		else {
			System.err.println("Invalid browser name.... Please select chrome and edge only");
			logger.error("Invalid browser name.... Please select chrome and edge only");
		}
	}

	public BrowserUtility(Browser browserName, boolean headless) {
		logger.info("opening the browser {}",browserName+" in headless");
		if(browserName==Browser.CHROME) {
			if (headless){
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options)) ;
			}
			else {
				driver.set(new ChromeDriver()) ;
			}
		}

		else if(browserName==Browser.EDGE) {
			if (headless){
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-gpu");
				driver.set(new EdgeDriver(options));
			}
			else {
				driver.set(new EdgeDriver());
			}
		}

		else if(browserName==Browser.FIREFOX) {
			if (headless){
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));
			}
			else {
				driver.set(new FirefoxDriver());
			}
		}
		else {
			System.err.println("Invalid browser name.... Please select chrome and edge only");
			logger.error("Invalid browser name.... Please select chrome and edge only");
		}
	}
	
	
	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void quitBrowser(){
		driver.get().quit();
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing window");
		driver.get().manage().window().maximize();
		logger.info("Window maximized");
	}
	
	public void clickOn(By locator) {
		logger.info("element clicked on "+locator);
		WebElement element = driver.get().findElement(locator);
		element.click();
		logger.info("clicked successful on element {}",element);
	}
	
	public void enterText(By locator,String text) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(text);
		logger.info("entered text is {}",element);
	}
	
	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		logger.info("visible text is {}",element.getText());
		return element.getText();
	}

	public String takeScreenshot(String name){
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "screenshots/"+name+"-"+timeStamp+".png";
        try {
            FileUtils.copyFile(screenshotData,new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		return path;
    }
}
