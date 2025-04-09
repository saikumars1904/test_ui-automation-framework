package com.ui.listeners;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.constants.Env.QA;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    //private static final int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(QA,"MAX_NUMBER_OF_ATTEMPTS"));
    private static final int MAX_NUMBER_OF_ATTEMPTS= JSONUtility.readJSON(QA).getMAX_NUMBER_OF_ATTEMPTS();
    private static int currentAttempts = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (currentAttempts<=MAX_NUMBER_OF_ATTEMPTS){
            currentAttempts++;
            return true;
        }
        return false;
    }
}
