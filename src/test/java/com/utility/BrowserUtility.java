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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private WebDriverWait wait;
    private Logger logger = LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(WebDriver driver) {
        BrowserUtility.driver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
    }


    public BrowserUtility(Browser browserName) {
        logger.info("opening the browser {}", browserName);
        if (browserName == Browser.CHROME) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
        } else if (browserName == Browser.EDGE) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
        } else if (browserName == Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
        } else {
            System.err.println("Invalid browser name.... Please select chrome and edge only");
            logger.error("Invalid browser name.... Please select chrome and edge only");
        }
    }


    public BrowserUtility(Browser browserName, boolean headless) {
        logger.info("opening the browser {}", browserName + " in headless");
        if (browserName == Browser.CHROME) {
            if (headless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
            } else {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
            }
        } else if (browserName == Browser.EDGE) {
            if (headless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
            } else {
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
            }
        } else if (browserName == Browser.FIREFOX) {
            if (headless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver.set(new FirefoxDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
            } else {
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10L));
            }
        } else {
            System.err.println("Invalid browser name.... Please select chrome and edge only");
            logger.error("Invalid browser name.... Please select chrome and edge only");
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        BrowserUtility.driver.set(driver);
    }

    public void goToWebsite(String url) {
        driver.get().get(url);
    }

    public void quitBrowser() {
        driver.get().quit();
    }

    public void maximizeWindow() {
        logger.info("Maximizing window");
        driver.get().manage().window().maximize();
        logger.info("Window maximized");
    }

    public void clickOn(By locator) {
        logger.info("element clicked on " + locator);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        logger.info("clicked successful on element {}", element);
    }

    public void clickOnCheckBox(By locator) {
        logger.info("element clicked on " + locator);
        WebElement element = driver.get().findElement(locator);
        element.click();
        logger.info("clicked successful on element {}", element);
    }

    public void clickOn(WebElement element) {
        logger.info("element clicked on " + element);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info("clicked successful on element {}", element);
    }

    public void enterText(By locator, String text) {
        logger.info("Finding element with locator " + locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
        logger.info("entered text is {}", text);
    }

    public void clearText(By locator) {
        logger.info("Finding element with locator " + locator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        ;
        logger.info("text box cleared successfully");
    }

    public void enterSpecialKey(By locator, Keys keysToEnter) {
        logger.info("Finding element with locator " + locator);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.sendKeys(keysToEnter);
        logger.info("entered key is {}", keysToEnter);
    }

    public String getVisibleText(By locator) {
        WebElement element = driver.get().findElement(locator);
        logger.info("visible text is {}", element.getText());
        return element.getText();
    }

    public List<String> getAllVisibleText(By locator) {
        logger.info("Find all elements with the locator {}", locator);
        List<WebElement> elementList = driver.get().findElements(locator);
        List<String> visibleTextList = new ArrayList<>();
        for (WebElement element : elementList) {
            System.out.println(getVisibleText(element));
            visibleTextList.add(getVisibleText(element));
        }
        //logger.info("visible text is {}",element.getText());
        return visibleTextList;
    }

    public List<WebElement> getAllElements(By locator) {
        logger.info("Find all elements with the locator {}", locator);
        List<WebElement> elementList = driver.get().findElements(locator);

        logger.info("Elements found and printing the list of elemets");
        return elementList;
    }

    public void selectFromDropDown(By dropdown) {
        logger.info("Finding dropdown element with locator " + dropdown);
        Select select = new Select(getDriver().findElement(dropdown));
        select.selectByVisibleText("California");
        logger.info("Selected option is " + getVisibleText(select.getFirstSelectedOption()));
    }

    public void selectFromDropDown(By dropdown, String visibleText) {
        logger.info("Finding dropdown element with locator " + dropdown);
        Select select = new Select(getDriver().findElement(dropdown));
        select.selectByVisibleText(visibleText);
        logger.info("Selected option is " + getVisibleText(select.getFirstSelectedOption()));
    }

    public String getVisibleText(WebElement element) {
        logger.info("visible text is {}", element.getText());
        return element.getText();
    }

    public String takeScreenshot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = "./screenshots/" + name + "-" + timeStamp + ".png";
        try {
            FileUtils.copyFile(screenshotData, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }


}
