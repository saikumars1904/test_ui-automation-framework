package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

import static com.utility.ExtentReporterUtility.*;

public class TestListeners implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test suite started");
        setUpSparkReporter("report.html");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        createExtentTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("{} passed", result.getMethod().getMethodName());
        getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("{} failed", result.getMethod().getMethodName());
        logger.error(result.getThrowable().getMessage());
        getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
        getTest().log(Status.FAIL,result.getThrowable().getMessage());
        Object testClass = result.getInstance();
        BrowserUtility browserUtility = ((TestBase)testClass).getInstance();
        logger.info("Capturing screenshot for the failed test case");
        String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
        getTest().addScreenCaptureFromPath(screenshotPath);
        logger.info("Attaching to the report");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("{} skipped", result.getMethod().getMethodName());
        getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
    }


    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test suite completed");
        flushReporter();
    }
}
