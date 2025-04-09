package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String fileName) {
        File csvFile = new File("testData/"+fileName);
        FileReader fileReader = null;
        CSVReader csvReader;
        String[] line;
        List<User> userList;
        try {
            //If no row or csvReader comes to the end of the file it returns null!!
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();
            userList = new ArrayList();
            User userData;
            while ((line = csvReader.readNext()) != null) {
                System.out.println(line.length);
                userData = new User(line[0], line[1]);
                userList.add(userData);
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
