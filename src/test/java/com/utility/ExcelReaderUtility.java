package com.utility;

import com.ui.pojos.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String fileName) {
        File xlsxFile = new File("testData/"+fileName);
        XSSFWorkbook xssfWorkbook;
        XSSFSheet sheet;
        User user;
        List<User> userList = new ArrayList<>();
        Row row;
        Cell emailCell;
        Cell passwordCell;
        Iterator<Row> rowIterator;

        try {
            xssfWorkbook = new XSSFWorkbook(xlsxFile);
            sheet = xssfWorkbook.getSheet("loginData");
            rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()){
                row = rowIterator.next();
                emailCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailCell.toString(),passwordCell.toString());
                userList.add(user);
                xssfWorkbook.close();
            }
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
