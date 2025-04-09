package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {

    public static final String HUBURL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<>();


    public static WebDriver initializeLambdaTestSession( String browser,String testName){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "akashdebnathlearning");
        ltOptions.put("accessKey", "uqLRHoM6uzttMZ2Jg0tOyTZ0o4gdrhfxCefD3H0idIBP7T1pxg");
        ltOptions.put("build", "Maven build");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(HUBURL), capabilitiesLocal.get());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driverLocal.set(driver);
        return driverLocal.get();
    }

    public static void quitSession(){
        if (driverLocal.get()!=null){
            driverLocal.get().quit();
        }
    }
}
