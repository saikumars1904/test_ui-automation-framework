package com.ui.dataproviders;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.utility.CSVReaderUtility.readCSVFile;
import static com.utility.ExcelReaderUtility.readExcelFile;

public class LoginDataProvider {

    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File("testData/loginData.json");
        FileReader fileReader = new FileReader(file);
        TestData data = gson.fromJson(fileReader, TestData.class);
        List<Object[]> dataToReturn = new ArrayList<>();
        for (User user : data.getData()) {
            System.out.println("Loaded user from JSON: " + user.getEmailAddress());
            dataToReturn.add(new Object[]{user});
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVProvider")
    public Iterator<User> loginCSVDataProvider(){
        return readCSVFile("loginData.csv");
    }

    @DataProvider(name = "LoginTestExcelProvider")
    public Iterator<User> loginExcelDataProvider(){
        return readExcelFile("loginData.xlsx");
    }
}
